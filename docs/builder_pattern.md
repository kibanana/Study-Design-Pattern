# Builder Pattern

[유니티 디자인패턴 - 빌더(Java와 GoF의 차이점) (Unity Design Patterns - Builder)](https://glikmakesworld.tistory.com/m/9)

[디자인패턴 공부내용 정리 : 빌더 패턴](https://semtax.tistory.com/m/85)

## GoF Builder Pattern
새로운 객체를 만드는 방법론이라는 점은 Java의 빌더 패턴과 같지만, 전혀 관점이 다르다. Java의 빌더 패턴은 Set 함수를 여러개 써서 내가 원하는 변수를 세팅하고, `Build()` 후에는 멤버변수를 수정할 수 없게 해서 안전하게 보호하는 데에 목적이 있다. 반면 GoF의 빌더 패턴은 객체지향적인 방식인데, 예시를 통해 설명하겠다.

생과일 주스를 만드는 타이쿤 게임이 있다고 해보자. 손님이 원하는대로 포도주스, 딸기주스를 만들어서 줘야 한다. 기계에 과일을 넣고, 버튼을 눌러 즙을 짜서 손님에게 주는 것은 동일하지만, 재료가 포도냐 딸기냐에 따라 다르다.

설계


|클래스명|설명|
|---|---|
|Juice|손님에게 줄 주스. 멤버변수 type에 따라 포도주스 혹은 딸기주스가 됨|
|JuiceBuilder|주스 객체를 만들고 세팅하는데에 필요한 멤버함수나 멤버변수를 선언해주는 추상 클래스|
|StrawberryJuiceBuilder, GrapeJuiceBuilder|JuiceBuilder를 상속받아 딸기주스 혹은 포도주스를 만드는 기능을 정의할 수 있는 실질적인 객체|
|JuiceMachine|JuiceBuilder의 함수들을 사용해서 때로는 딸기주스 빌더, 때로는 포도|

```java
public class Juice
{
    public enum JuiceType
    {
        None,
        Grape,
        Strawberry
    }

    public JuiceType type = JuiceType.None;

    public void SetType(JuiceType type)
    {
        this.type = type;
    }
}
```

```java
public abstract class JuiceBuilder
{
    //만들어질 주스를 담을 변수
    protected Juice juice;

    //주스를 리턴
    public Juice CreateJuice()
    {
        return juice;
    }

    //새로운 주스를 만들 준비
    public void PrepareNewJuice()
    {
        juice = new Juice();
    }

    //주스를 만들기 전에 과일 세팅을 하는 추상함수. 내용물 정의는 하위 클래스에서 해줄 것이다.
    public abstract void SetFruit();
}
```

```java
//딸기주스 빌더
public class StrawberryJuiceBuilder : JuiceBuilder
{
    public override void SetFruit()
    {
        juice.SetType(Juice.JuiceType.Strawberry);
    }
}

//포도주스 빌더
public class GrapeJuiceBuilder : JuiceBuilder
{
    public override void SetFruit()
    {
        juice.SetType(Juice.JuiceType.Grape);
    }
}
```

```java
public class JuiceMachine
{
    //딸기주스빌더 혹은 포도주스빌더를 담을 변수.
    private JuiceBuilder juiceBuilder;

    //딸기주스빌더 혹은 포도주스빌더를 세팅하는 함수.
    public void SetJuiceBuilder(JuiceBuilder builder)
    {
        juiceBuilder = builder;
    }

    //빌더가 세팅되었다면 본격적으로 주스를 만들 준비를 한다.
    public void MakeJuice()
    {
        juiceBuilder.PrepareNewJuice();
        juiceBuilder.SetFruit();
    }

    //주스 만들 준비가 끝났다면 주스를 만들어서 손님에게 준다.
    public Juice GetJuice()
    {
        return juiceBuilder.CreateJuice();
    }
}
```

```java
public class AppMain : MonoBehaviour
{
    // Start is called before the first frame update
    void Start()
    {
        JuiceMachine machine = new JuiceMachine();
        GrapeJuiceBuilder grapeJuiceBuilder = new GrapeJuiceBuilder();
        StrawberryJuiceBuilder strawberryJuiceBuilder = new StrawberryJuiceBuilder();

        //포도주스 제조.
        machine.SetJuiceBuilder(grapeJuiceBuilder);
        machine.MakeJuice();
        Juice grapeJuice = machine.GetJuice();

        //딸기주스 제조.
        machine.SetJuiceBuilder(strawberryJuiceBuilder);
        machine.MakeJuice();
        Juice strawberryJuice = machine.GetJuice();

    }
}
```

## Effective Java Builder Pattern

객체를 만들 때 private 변수를 각각 개별 함수로 세팅하고, 변수설정이 끝났다면 객체를 만들어 반환하는 방법이다. 이때 만들어진 객체는 멤버변수를 다시는 수정할 수 없도록 해서 안전하게 보호할 수 있다.

```java
public class SaveData
{
    public string name{ get; private set; }
    public int level{ get; private set; }
    public string location{ get; private set; }

    public SaveData(string tName, int tLevel, string tLocation)
    {
        this.name = tName;
        this.level = tLevel;
        this.location = tLocation;
    }
    
    //세이브 데이터를 생성해주는 빌더 클래스.
    public class SaveDataBuilder
    {
        private string name = "defaultName";
        private int level = -1;
        private string location = "시작의 마을 여관";

        //개발자가 판단하기에 가장 중요한 변수는 생성자에 넣어서 반드시 세팅되도록 해준다.
        public SaveDataBuilder(string tName)
        {
            this.name = tName;
        }

        //이하는 Setter함수들. 리턴값으로 this를 해주는게 바로 포인트.
        public SaveDataBuilder SetLevel(int tLevel)
        {
            this.level = tLevel;
            return this;
        }

        public SaveDataBuilder SetLocation(string tLocationh)
        {
            this.location = tLocationh;
            return this;
        }

        //원하는 값들이 세팅되면 최종적으로 이 함수를 실행해서 세이브 데이터 객체를 하나 만들어준다.
        public SaveData Build()
        {
            return new SaveData(name, level, location);
        }
    }
}
```

```java
public class AppMain : MonoBehaviour
{
    // Start is called before the first frame update
    void Start()
    {
        //각 Set 함수를 실행하면 SaveDataBuilder가 리턴되기 때문에 걔속해서 .Set 이런식으로 멤버변수 세팅 가능. 
        //최종적으로 Build()를 실행하면 설정한 값에 따라 SaveData객체가 만들어짐.
        //이후엔 save1의 멤버변수를 수정할 방도가 없어서, 데이터를 보호할 수 있음.
        //만약 내가 설정하기 싫은 변수가 있으면 그 변수에 대한 Set함수를 사용 안하면 된다.
        SaveData save1 = new SaveData.SaveDataBuilder("글릭").SetLevel(1).SetLocation("발라마을 여관").Build();

    }
}
```

---

빌더 패턴 - 생성 패턴 중 하나

- 배경
    
    복잡한 객체를 생성하는데 초기화를 단계별로 해야할 때, 어떻게 깔끔하게 코드를 작성할 수 있을까를 고민하다 나온 패턴
    
    ex) 자동차 조립, 피자 만들기

- 상황
  
    피자라는 객체를 만든다고 가정해보자. 피자에는 올리브 토핑, 페퍼로니 토핑, 피망, 고기도 들어갈 수 있다. 하지만 저 재료들을 무조건 넣어야하는 게 아니고 선택적으로 넣는다.

    일단 가장 단순한 방법은 이런 케이스를 모두 커버하는 생성자를 만드는 것이다. 그럼 코드가 상당히 지저분하게 나온다.

    ```java
    public class Pizza {
          private String pepperoni;
          private String paprika;
          private String meat;
          private String olive;
          private String cheese;
          private String bread;
        
          public Pizza() {
        
          }
        
          public Pizza(String bread) {
            this.bread = bread;
          }
        
          public Pizza(String bread, String cheese) {
            this.bread = bread;
            this.cheese = cheese;
          }
        
          ...
    }
    ```

- 해결법
  
    위에서 선언했던 모든 생성자들을 빌더라는 별도 클래스로 추출한다.

    그리고 추출한 각 생성자들을 빌더 클래스의 메서드로 만든다. 이 때, 빌더 클래스의 메서드들이 빌더 객체 자신을 리턴하게 해서 위에서 선언한 함수들을 연속적으로 호출할 수 있게 하는 방식으로 구현한다.

    마지막으로 `build` 메서드를 호출하면 실제로 빌더 클래스가 생성한 객체를 돌려준다.

- 구현법
  
    ```java
    public class Pizza {
    
          private String pepperoni;
          private String paprika;
          private String meat;
          private String olive;
          private String cheese;
          private String bread;
        
          public Pizza(String bread, String cheese, String pepperoni, String paprika, String meat, String olive) {
                this.bread = bread;
                this.cheese = cheese;
                this.pepperoni = pepperoni;
                this.paprika = paprika;
                this.meat = meat;
                this.olive = olive;
          }
    }
    ```

    ```java
    public class PizzaBuilder {

          private String pepperoni;
          private String paprika;
          private String meat;
          private String olive;
          private String cheese;
          private String bread;
        
          public PizzaBuilder(String bread, String cheese) {
                this.bread = bread;
                this.cheese = cheese;
          }
        
          public PizzaBuilder addPaprika(String paprika) {
                this.paprika = paprika;
          }
        
        
          public PizzaBuilder addMeat(String meat) {
                this.meat = meat;
          }
        
          public PizzaBuilder addOlive(String olive) {
                this.olive = olive;
          }
        
          public PizzaBuilder addPepperoni(String pepperoni) {
                this.pepperoni = pepperoni;
          }
        
          public Pizza build(){
                return new Pizza(this.bread, this.cheese, this.pepperoni, this.paprika, this.meat, this.olive);
          }
    }
    ```
    
    ```java
    public class Main {
          public static void main(String[] args) {
                PizzaBuilder builder = new PizzaBuilder("crust","pamasan");
                Pizza nicePizza = builder.addPaprika("yellow paprika")
                      .addMeat("cow meat")
                      .addOlive("black olive")
                      .addPepperoni("red pepperoni")
                      .build();
          }
    }
    ```

- 예시
    - `Retrofit2` [Github](https://square.github.io/retrofit/)

        ```java
        public interface GitHubService {
              @GET("users/{user}/repos")
              Call<List<Repo>> listRepos(@Path("user") String user);
        }
            
        ...
        
        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .build();
        
        GitHubService service = retrofit.create(GitHubService.class);
        ```








