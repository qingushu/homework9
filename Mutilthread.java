public class Mutilthread {

    int status=1;
    public static void main(String[] args) {

        Mutilthread mutilthread = new Mutilthread();

        A1 a=new A1(mutilthread);
        A2 b=new A2(mutilthread);
        A3 c=new A3(mutilthread);
        A4 d=new A4(mutilthread);
       System.out.println();
        a.start();
        b.start();
        c.start();
        d.start();

    }
}

class A1 extends Thread{
    Mutilthread mutilthread;

    A1(Mutilthread mutilthread){
        this.mutilthread = mutilthread;
    }


    public void run() {

        try{
          char[] arr1 = {'A','E','I','M' ,'Q', 'U', 'Y'};
            synchronized (mutilthread) {

                for (int i = 0; i < 7; i++) {

                    while(mutilthread.status!=1){
                        mutilthread.wait();
                    }

                    System.out.print(arr1[i]);
                    mutilthread.status = 2;
                    mutilthread.notifyAll();
                }

            }
        }catch (Exception e) {
            System.out.println("Exception 1 :"+e.getMessage());
        }

    }

}

class A2 extends Thread{

    Mutilthread mutilthread;

    A2(Mutilthread mutilthread){
        this.mutilthread = mutilthread;
    }


    public void run() {

        try{
           char[] arr2 = {'B', 'F', 'J' ,'N' ,'R' ,'V' ,'Z'};
            synchronized (mutilthread) {

                for (int i = 0; i < 7; i++) {

                    while(mutilthread.status!=2){
                        mutilthread.wait();
                    }

                    System.out.print(arr2[i]);
                    mutilthread.status = 3;
                    mutilthread.notifyAll();
                }

            }
        }catch (Exception e) {
            System.out.println("Exception 2 :"+e.getMessage());
        }

    }
}


class A3 extends Thread{

    Mutilthread mutilthread;

    A3(Mutilthread mutilthread){
        this.mutilthread = mutilthread;
    }

    public void run() {

        try{
           char[] arr3 = {'C', 'G', 'K' ,'O' ,'S' ,'W'};
            synchronized (mutilthread) {

                for (int i = 0; i < 6; i++) {

                    while(mutilthread.status!=3){
                        mutilthread.wait();
                    }

                    System.out.print(arr3[i]);
                    mutilthread.status = 4;
                    mutilthread.notifyAll();
                }

            }
        }catch (Exception e) {
            System.out.println("Exception 3 :"+e.getMessage());
        }

    }
}

class A4 extends Thread{

    Mutilthread mutilthread;

    A4(Mutilthread mutilthread){
        this.mutilthread = mutilthread;
    }


    public void run() {

        try{
           char[] arr4 = {'D', 'H', 'L' ,'P' ,'T' ,'X'};
            synchronized (mutilthread) {

                for (int i = 0; i < 6; i++) {

                    while(mutilthread.status!=4){
                        mutilthread.wait();
                    }

                    System.out.print(arr4[i]);
                    mutilthread.status = 1;
                    mutilthread.notifyAll();
                }

            }
        }catch (Exception e) {
            System.out.println("Exception 4 :"+e.getMessage());
        }

    }
}
