# Proxy Pattern

[프록시 패턴(Proxy Pattern)](https://jdm.kr/blog/235)

## 정의
실제 기능을 수행하는 객체(Real Object) 대신 가상의 객체(Proxy Object)를 사용해 로직의 흐름을 제어하는 디자인 패턴

## 특징
- 원래 기능을 수행하며 그 외의 부가적인 작업(로깅, 인증, 네트워크 통신 등)을 수행하기에 좋다.
- 비용이 많이 드는 연산(DB 쿼리, 대용량 텍스트 파일 관련 처리 등)이 실제로 필요한 시점에 수행할 수 있다.
- 사용자 입장에서는 프록시 객체나 실제 객체나 사용법은 유사하므로 사용성이 좋다.

## 클래스 다이어그램

![img.png](proxyPattern.png)

- Client는 Subject(interface)를 사용한다.
- Real Object, Proxy Object는 Subject(interface)를 구현한다.
- Proxy Object는 Real Object에 위임한다.
    - 프록시 객체는 메서드 수행 시 실제 객체의 메서드에 위임한다.

## 종류

프록시 패턴에서 사용할 수 있는 프록시의 종류는 다양하다.

## 가상 프록시(Virtual Proxy)

가상 프록시는 실제 객체의 사용 시점을 제어할 수 있습니다. 예를 들어 늦은 초기화(Lazy Initialization)를 프록시를 통해 구현해 봅시다.

아래처럼 텍스트 파일을 읽는 인터페이스가 있다고 가정합시다.

```java
interface TextFile {
    String fetch();
}
```

메서드가 하나밖에 없는 아주 간단한 인터페이스이며, 앞으로 이 인터펯이스를 구현하는 클래스는 반드시 `fetch()` 메서드를 구현해야 합니다.

이제부터 시나리오를 가정합시다.

> 보안 전자 서류 전문 업체에 근무하고 있는 개발자. 콘솔프로그램으로 난독화된 전자 서류의 본문을 20개씩 복호화해서 보여주는 프로그램을 작성할 것이다.

실제 업무를 수행하기에 앞서 협업 조직에서 `SecretTextFile`이라는 클래스를 인수 받았습니다.

```java
class SecretTextFile extends TextFile {
    private String plainText;
    
    public SecretTextFile(String fileName) {
        this.plainText = SecretFileHolder.decodeByFileName(fileName);
    }
    
    @Override
    public String fetch() {
        return plainText;
    }
}
```

```java
class SecretFileHolder { // 더미 메서드
    public static String decodeByFileName(String name) {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return name;
    }
}
```

`SecretTextFile` 클래스는 난독화 되어 있는 텍스트 파일을 복호화해서 평문으로 바꿔주는 클래스입니다. 협업 조직에서 라이브러리로 제공한 클래스라고 가정합시다. 즉, 저는 이 클래스를 수정할 권한은 없습니다.

이 클래스를 그대로 사용해서 콘솔 프로그램을 구성했습니다. 하지만 실행 시켜보고 첫 결과가 나오기까지 `6초`라는 시간이 걸리는 것을 알게 됩니다. `6초`는 제대로 프로그램이 동작하고는 있는지 의심하기에 충분한 시간입니다.

이유를 확인해보니 `SecretTextFile` 클래스에서 사용중인 `SecretFileHolder.decodeByFileName()` 메서드의 수행속도가 `0.3초`라는 것을 발견하게 됩니다. 그리고 목록에 20개의 파일 내용을 노출해야 하는 상태였기 때문에 문제가 된겁니다. 화면을 구성할 때 이 파일들을 전부 객체로 만들다 보니 `6초` 정도의 로딩 시간을 갖게 된것이죠.

문제를 확인했으니 코드 리팩토링을 하기로 결심합니다. 그래서 프록시 패턴을 적용해 필요할때만 파일 복호화를 하도록 수정하기로 했습니다. 다음의 클래스를 볼까요. 이제 프록시 클래스를 구현할 때입니다.

```java
class ProxyTextFile implements TextFile {
    private String fileName;
    private TextFile textFile;
    
    public ProxyTextFile(String fileName) {
        this.fileName = fileName;
    }
    
    @Override
    public String fetch() {
        if (textFile == null) {
            textFile = new SecretTextFile(fileName);
        }
        return "[proxy] " + textFile.fetch();
    }
}
```

```java
void main() {
    List<TextFile> textFileList = new ArrayList<>();
    textFileList.addAll(TextFileProvider.getSecretTextFile(0. 3));
    textFileList.addAll(TextFileProvider.getProxyTextFile(3, 20));
    textFileList.stream().map(TextFile::fetch).forEach(System.out::println);    
}
```

```java
class TextFileProvider {
    public static List<SecretTextFile> getSecretTextFile(int start, int end) {
        return IntStream.range(start, end)
                .mapToObj(i -> new SecretTextFile(String.valueOf(i)))
                .collect(Collectors.toList());
    }

    public static List<ProxyTextFile> getProxyTextFile(int start, int end) {
        return IntStream.range(start, end)
                .mapToObj(i -> new ProxyTextFile(String.valueOf(i)))
                .collect(Collectors.toList());
    }
}
```

`textFileList`를 사용하는 입장에서는 별다른 조치없이 그대로 사용하면 됩니다. 콘솔에서 `textFileList`를 순회하면서 노출한다고 하면 처음 세 개는 이미 로딩이 되어 있는 상태이므로 바로 노출하고 그 다음 아이템부터는 차근차근 노출할겁니다.

따라서 `ProxyTextFile` 같은 프록시 클래스를 만들고 기존 `SecretTextFile` 클래스 대신 사용한 것만으로도 초기 객체 생성 시간이 대폭 감소했습니다. 정말 필요한 시점에만 텍스트 복호화를 하게 되었죠. 이렇게 초기 비용이 많이 드는 연산이 포함된 객체의 경우 가상 프록시를 사용했을 때 효과를 볼 수 있습니다.

- Client
- Subject -> TextFile
- Proxy Object -> ProxyTextFile
- Real Objct -> SecretTextFile

## 보호 프록시(Protection Proxy)

보호 프록시는 프록시 객체가 사용자의 실제 객체에 대한 접근을 제어합니다.

새로운 시나리오입니다.

> 인사팀에서 인사정보에 대한 데이터 접근을 직책 단위로 세분화 하려고 합니다. 기존에는 오로지 인사팀에서만 사용했던 부분이었으나 최근 인사정보를 직책별로 공개해줘야 하는 경우가 생겼기 때문입니다. 따라서 전산팀에 근무중인 나는 직책에 따라서 조직원의 인사정보 접근을 제어하는 업무를 수행해야합니다.

```java
// 직책 등급(차례대로 조직원 staff, 조직장 manager, 부사장 vice president)
enum GRADE {
    Staff, Manager, VicePresident
}

// 구성원
interface Employee {
    String getName(); // 구성원의 이름
    GRADE getGrade(); // 구성원의 직책
    String getInformation(Employee viewer); // 구성원의 인사정보(매개변수는 조회자)
}

// 일반 구성원
class NormalEmployee implements Employee {
    private String name;
    private GRADE grade;

    public NormalEmployee(String name, GRADE grade) {
        this.name = name;
        this.grade = grade;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public GRADE getGrade() {
        return grade;
    }

    // 기본적으로 자신의 인사정보는 누구나 열람할 수 있도록 되어있습니다.
    @Override
    public String getInformation(Employee viewer) {
        return "Display " + getGrade().name() + " '" + getName() + "' personnel information.";
    }
}
```

이 상태로 놔두면 누구든지 `Employee` 객체에서 `getInformation()` 메서드를 호출하면 누가 조회하든 정보를 보여줄 것입니다. 이제부터 보호 프록시 클래스를 구성해봅시다. 이 클래스는 조회자의 직책을 확인하고 예외를 던지거나 인사 정보를 노출할 수 있도록 실제 객체에게 위임합니다.

```java
// 인사정보가 보호된 구성원(인사 정보 열람 권한 없으면 예외 발생)
class ProtectedEmployee implements Employee {
    private Employee employee;

    public ProtectedEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String getInformation(Employee viewer) {
        // 본인 인사정보 조회
        if (this.employee.getGrade() == viewer.getGrade() && this.employee.getName().equals(viewer.getName())) {
            return this.employee.getInformation(viewer);
        }

        switch (viewer.getGrade()) {
            case VicePresident:
            	// 부사장은 조직장, 조직원들을 볼 수 있다.
                if (this.employee.getGrade() == GRADE.Manager || this.employee.getGrade() == GRADE.Staff) {
                    return this.employee.getInformation(viewer);
                }
            case Manager:
                if (this.employee.getGrade() == GRADE.Staff) { // 조직장은 조직원들을 볼 수 있다.
                    return this.employee.getInformation(viewer);
                }
            case Staff:
            default:
                throw new NotAuthorizedException(); // 조직원들은 다른 사람의 인사정보를 볼 수 없다.
        }
    }

    @Override
    public String getName() {
        return employee.getName();
    }

    @Override
    public GRADE getGrade() {
        return employee.getGrade();
    }
}

class NotAuthorizedException extends RuntimeException { // 보호 프록시에서 메서드 호출시 조회자에게 권한이 없으면 NotAuthorizedException 예외를 던진다.
    private static final long serialVersionUID = -1714144282967712658L;
}
```

```java
public void main() {
    // 직원별 개인 객체 생성
    Employee CTO = new NormalEmployee("Dragon Jung", GRADE.VicePresident);
    Employee CFO = new NormalEmployee("Money Lee", GRADE.VicePresident);
    Employee devManager = new NormalEmployee("Cats Chang", GRADE.Manager);
    Employee financeManager = new NormalEmployee("Dell Choi", GRADE.Manager);
    Employee devStaff = new NormalEmployee("Dark Kim", GRADE.Staff);
    Employee financeStaff = new NormalEmployee("Pal Yoo", GRADE.Staff);

    // 직원들을 리스트로 가공
    List<Employee> employees = Arrays.asList(CTO, CFO, devManager, financeManager, devStaff, financeStaff);

    System.out.println("================================================================");
    System.out.println("시나리오1. Staff(Dark Kim)가 회사 인원 인사 정보 조회");
    System.out.println("================================================================");

    // 자신의 직급에 관계 없이 모든 직급의 인사 정보를 열람 (문제!!)
    printAllInformationInCompany(devStaff, employees);

    System.out.println("================================================================");
    System.out.println("보호 프록시 서비스를 가동.");
    System.out.println("================================================================");
    List<Employee> protectedEmployees = employees.stream().map(ProtectedEmployee::new).collect(Collectors.toList());

    System.out.println("================================================================");
    System.out.println("시나리오2. Staff(Dark Kim)가 회사 인원 인사 정보 조회");
    System.out.println("================================================================");
    printAllInformationInCompany(devStaff, protectedEmployees);

    System.out.println("================================================================");
    System.out.println("시나리오3. Manger(Cats Chang)가 회사 인원 인사 정보 조회");
    System.out.println("================================================================");
    printAllInformationInCompany(devManager, protectedEmployees);

    System.out.println("================================================================");
    System.out.println("시나리오4. VicePresident(Dragon Jung)가 회사 인원 인사 정보 조회");
    System.out.println("================================================================");
    printAllInformationInCompany(CTO, protectedEmployees);
}

public void printAllInformationInCompany(Employee viewer, List<Employee> employees) {
    employees.stream()
            .map(employee -> {
                try {
                    return employee.getInformation(viewer);
                } catch (NotAuthorizedException e) {
                    return "Not authorized.";
                }
            })
            .forEach(System.out::println);
}
```
