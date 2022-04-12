package assignment04PartE;

/**
 * Part E
 */

public final class Student implements Comparable<Student> {
    public static String prio;
    String firstname;
    String lastname;
    int id;
    double gpa;
    int smallQ;
    int largeQ;

    public Student(String first, String last, int idNum, double GpaNum, int smallQNum, int largeQNum) {
        firstname = first;
        lastname = last;
        id = idNum;
        gpa = GpaNum;
        smallQ = smallQNum;
        largeQ = largeQNum;
    }

    public static void setCompareToPriority(String priority) {
        prio = priority;
    }

    public static String[] getPriorities() {
        //Priority array
        //return new String[]{"realistic (provided by supervisors)", "first", "last", "id", "gpa", "smallQ", "largeQ","smallQ_largeQ"};
        return new String[]{"realistic", "first-name", "last-name", "student-id", "gpa", "number-of-small-questions", "number-of-big-questions", "number-of-small-and-big-questions"};
    }


    @Override
    public int compareTo(Student o) {
        //System.out.println(prio);
        if (prio.equals("realistic")) {
            return 0;
        }
        if (prio.equals("first-name")) {
            //System.out.println(firstname.compareTo(o.firstname));
            //compareTo didnt work
            //return firstname.compareTo(o.firstname);
            for (int i = 0; i < firstname.length(); i++) {
                for (int j = i + 1; j < o.firstname.length(); j++) {
                    if (firstname.charAt(i) > o.firstname.charAt(j)) {
                        return -1;
                    }
                    if (firstname.charAt(i) < o.firstname.charAt(j)) {
                        return 1;
                    }
                    return 0;
                }
            }

        }
        if (prio.equals("last-name")) {
            //System.out.println(lastname.compareTo(o.lastname));
            //compareTo didnt work
            //return lastname.compareTo(o.lastname);
            for (int i = 0; i < lastname.length(); i++) {
                for (int j = i + 1; j < o.lastname.length(); j++) {
                    if (lastname.charAt(i) > o.lastname.charAt(j)) {
                        return -1;
                    }
                    if (lastname.charAt(i) < o.lastname.charAt(j)) {
                        return 1;
                    }
                    return 0;
                }
            }
        }
        if (prio.equals("student-id")) {
            //System.out.println(Integer.toString(id).compareTo(Integer.toString(o.id)));
            //return Integer.toString(id).compareTo(Integer.toString(o.id));
            if (id < o.id) {
                return -1;
            }
            if (id > o.id) {
                return 1;
            }
            return 0;
        }
        if (prio.equals("gpa")) {
            //System.out.println(Double.toString(gpa).compareTo(Double.toString(o.gpa)));
            //return Double.toString(gpa).compareTo(Double.toString(o.gpa));
            if (gpa < o.gpa) {
                return -1;
            }
            if (gpa > o.gpa) {
                return 1;
            }
            return 0;
        }
        if (prio.equals("number-of-small-questions")) {
            //System.out.println(Integer.toString(smallQ).compareTo(Integer.toString(o.smallQ)));
            //return Integer.toString(smallQ).compareTo(Integer.toString(o.smallQ));
            if (smallQ < o.smallQ) {
                return -1;
            }
            if (smallQ > o.smallQ) {
                return 1;
            }
            return 0;
        }
        if (prio.equals("number-of-big-questions")) {
            //System.out.println(Integer.toString(largeQ).compareTo(Integer.toString(o.largeQ)));
            //return Integer.toString(largeQ).compareTo(Integer.toString(o.largeQ));
            if (largeQ < o.largeQ) {
                return -1;
            }
            if (largeQ > o.largeQ) {
                return 1;
            }
            return 0;
        }
        if (prio.equals("number-of-small-and-big-questions")) {
            int total = smallQ + largeQ;
            int Ototal = o.smallQ + o.largeQ;
            //System.out.println(total + " " + Ototal);
            if (total < Ototal) {
                return -1;
            }
            if (total > Ototal) {
                return 1;
            }
            return 0;
        }
        return 0;
    }
}