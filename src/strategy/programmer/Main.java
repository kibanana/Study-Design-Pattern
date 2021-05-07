package strategy.programmer;

public class Main {
    public static void main(String[] args) {
        Programmer advancedP = new WebProgrammerAdvanced();
        Programmer amateurP = new WebProgrammerAmateur();

        System.out.println(advancedP.getAllSkills());
        System.out.println(amateurP.getAllSkills());

        amateurP.setServer(new WebServerSideAdvanced());

        System.out.println("===== 아마추어 프로그래머가 열심히 공부했다 =====");
        System.out.println(amateurP.getAllSkills());
    }
}
