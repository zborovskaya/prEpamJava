class Quest {
    public Quest () {System.out.println("1 work");}
    public Quest (int i) {this (i, i); System.out.println("2 work");}
    public Quest (int i, int j) {this (); System.out.println("3 work");}
    public static void main (String [] args) {
        Quest q = new Quest (2,3); //1
    }
}
