/*(a) Each candidate has a name, an address, and an age. The application reads
        this information first, saves it in objects, and uses the information to count
        votes, which are now submitted by typing the candidates’ names.*/

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Candidate {

    private String name;
    private String address;
    private int age;
    private int voteCount;

    public Candidate() {

    }

    public Candidate(String name, String address, int age) {
        this.name = name;
        this.address = address;
        this.age = age;
    }
    public Candidate(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    @Override
    public String toString() {
        return "Candidate: " + name  + ",  " + address + " has " + voteCount + " votes.";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candidate candidate = (Candidate) o;
        return Objects.equals(name, candidate.name);
    }

    public static void main(String[] args) {
        List<Candidate> data = getData();
        boolean voting = true;
        while (voting) {
            String input = JOptionPane.showInputDialog("Candidate name(Joe, Donald, Barack, Ryan ex for exit): ");
            if(data.contains(new Candidate(input))){
                Candidate candidate = data.get(data.indexOf(new Candidate(input)));
                candidate.voteCount += 1;
            }
            else if (input.equals("ex")) {
                voting = false;
            }else {
                JOptionPane.showMessageDialog(null, "Invalid candidate name");
            }
        }

        for(Candidate candidate: data){
            System.out.println(candidate);
        }
    }

    private static List<Candidate> getData() {
        List<Candidate> returnData = new ArrayList<>();
        returnData.add(new Candidate("Joe", "Washington", 62));
        returnData.add(new Candidate("Donald", "NY", 60));
        returnData.add(new Candidate("Barack", "Ohio", 54));
        returnData.add(new Candidate("Ryan", "Ohio", 57));

        return returnData;
    }
}