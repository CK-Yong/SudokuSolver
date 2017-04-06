import java.util.*;

class ArrayMaster {
int[] Array = new int[10];

public void GenerateArray(){
        System.out.println("\nHere's an array:");
        for(int i=0; i<Array.length; i++) {
                int value = (int)(Math.random()*101); //if not 101, then the number will never be 100
                Array[i] = value;
                System.out.print(Array[i]+"  ");
        }
        System.out.println("\n");
}

public void HighestValue(){
        int a = 0;        //Will be the highest value.
        int b = 0; //Value to compare a with.
        for(int i=0; i<Array.length; i++) {
                b = Array[i];
                if(a<b) {
                        a = b;
                }
        }
        System.out.println("Highest value of the array is: "+a);
}

public void LowestTwo(){
        int a = 100; // a and b will be the lowest two values.
        int b = 100;
        int c = 0; // c will be the value to compare with.

        for(int i=0; i<       Array.length; i++) { //allocating lowest value to a.
                c = Array[i];
                if(c<a) {
                        a = c;
                }
        }

        for(int i=0; i<Array.length; i++) {
                c = Array[i];
                if(c<b && c>a) {
                        b = c;
                }
        }
        System.out.println("Lowest two values: "+a+" and "+b);
}

public void filterEven(){
        int a = 0; // will store the value for checking even number
        System.out.print("Even numbers within the array (zero is not considered): ");
        for(int i = 0; i<Array.length; i++) {
                a = Array[i];
                if(a%2==0 && a!=0) {
                        System.out.print(a+"  ");
                }
        }
        System.out.print("\n");
}

public void split(){
        List<Integer> div2 = new ArrayList<>();
        List<Integer> div3 = new ArrayList<>();
        List<Integer> div5 = new ArrayList<>();
        List<Integer> remain = new ArrayList<>();

        for(int i = 0; i<Array.length; i++) {
                if(Array[i]%2==0 && Array[i]!=0) {
                        div2.add(Array[i]);
                }
        }
        if(div2.size()!=0) {
                System.out.println("Numbers in array, divisible by two: "+div2);
        } else {
                System.out.println("No numbers divisible by two.");
        }

        for(int i=0; i<Array.length; i++) {
                if(Array[i]%3==0 && Array[i]!=0) {
                        div3.add(Array[i]);
                }
        }
        if(div3.size()!=0) {
                System.out.println("Numbers in array, divisible by three: "+div3);
        } else {
                System.out.println("No numbers divisible by three.");
        }

        for(int i=0; i<Array.length; i++) {
                if(Array[i]%5==0 && Array[i]!=0) {
                        div5.add(Array[i]);
                }
        }
        if(div5.size()!=0) {
                System.out.println("Numbers in array, divisible by five: "+div5);
        } else {
                System.out.println("No numbers divisible by five.");
        }

        for(int i=0; i<Array.length; i++) {
                if(Array[i]%2!=0 && Array[i]%3!=0 && Array[i]%5!=0) {
                        remain.add(Array[i]);
                }
        }
        if(remain.size()!=0) {
                System.out.println("Remaining numbers: "+remain);
        } else {
                System.out.println("No remaining numbers.");
        }
}

public void bubbleSort(){
        int a = 0; //Bubblesort requires two variables which are to be compared.
        int b = 0;
        int[] sortArray = new int[10];
        boolean ArraySorted = false;
        boolean SortedOnce = false;

        while(ArraySorted==false) {
                SortedOnce = false;
                for(int i=0; i<Array.length-1; i++) {
                        a = Array[i];
                        b = Array[i+1];
                        if(a>b) {
                                Array[i] = b;
                                Array[i+1] = a;
                                SortedOnce = true;
                        }

                        if(i==Array.length-2 && SortedOnce == false) {
                                ArraySorted = true;
                                System.out.print("Sorted the array: ");
                                for(i=0; i<Array.length; i++) {
                                        System.out.print(Array[i]+"  ");
                                }
                        }
                }
        }
}

}

public class Lists {
public static void main(String[] args) {
        ArrayMaster master = new ArrayMaster();
        master.GenerateArray();
        master.HighestValue();
        master.LowestTwo();
        master.filterEven();
        master.split();
        master.bubbleSort();
}
}
