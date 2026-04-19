class student
{
    int rollno, sem;
    String name, address;
    void getdata(int r, int s, String n, String a)
    {
        rollno = r;
        sem = s;
        name = n;
        address = a;
    }
    void putdata()
    {
        System.out.println(rollno+"\t"+name+"\t"+sem+"\t"+address);
    }
}
class StudentDemo {
    public static void main(String args[])
    {
        student s1 = new student();
        student s2 = new student();
        s1.getdata(111,8,"abc","bagalkote");
        s2.getdata(222,8,"pqr","bangalore");
        s1.putdata();
        s2.putdata();
    }
}
