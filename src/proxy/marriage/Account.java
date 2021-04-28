package proxy.marriage;

public class Account implements PersonBean {
    String name;
    String gender;
    String interest;
    int rating;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getGender() {
        return gender;
    }

    @Override
    public String getInterest() {
        return interest;
    }

    @Override
    public int getHotOrNotRating() {
        return rating;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public void setInterest(String interest) {
        this.interest = interest;
    }

    @Override
    public void setHotOrNotRating(int rating) {
        this.rating = rating;
    }
}
