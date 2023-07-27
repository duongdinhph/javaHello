import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.PriorityQueue;
public class Med {



    public static void main(String[] args) {
        try {
            PriorityQueue<Integer> highPQ = new PriorityQueue<>();
            PriorityQueue<Integer> lowPQ = new PriorityQueue<>();
            File myObj = new File("median.txt");
            Scanner myReader = new Scanner(myObj);
            int i = 2;
            int firstNum, secondNum;
            int sumMod = 0;
            firstNum = Integer.parseInt(myReader.nextLine());
            secondNum = Integer.parseInt(myReader.nextLine());
            if(firstNum < secondNum)
            {
                lowPQ.add(-firstNum);
                highPQ.add(secondNum);
            }
            else{
                lowPQ.add(-secondNum);
                highPQ.add(firstNum);
            }
//            sumMod += (-lowPQ.peek())*2;
//            sumMod %= 10_000;
            sumMod = 2793 + 6331;
            while (myReader.hasNextLine()) {
                i++;
//                System.out.println(i + " " + sumMod);
//                System.out.println(i + " " + lowPQ.size() + " " + highPQ.size());
                String data = myReader.nextLine();
                int num = Integer.parseInt(data);
                if(num < highPQ.peek())
                {
                    lowPQ.add(-num);
                }
                else{
                    highPQ.add(num);
                }
                if(lowPQ.size() == (highPQ.size()+2))
                {
                    int maxOfLow = -(lowPQ.poll());
                    highPQ.add(maxOfLow);
                } else if (highPQ.size() == (lowPQ.size()+2)) {
                    int minOfHigh = highPQ.poll();
                    lowPQ.add(-minOfHigh);
                }
                if(highPQ.size() > lowPQ.size())
                {
                    sumMod += highPQ.peek();
                    if( i < 10)
                        System.out.println(i + " h " + highPQ.peek());
                }
                else {
                    sumMod += -(lowPQ.peek());
                    if( i < 10)
                        System.out.println( i + " l " + -lowPQ.peek());
                }
                sumMod %= 10_000;
            }
            System.out.println("result: " + sumMod);

        }
         catch (FileNotFoundException e) {
                System.out.println("error");
                e.printStackTrace();
            }
    }
}
