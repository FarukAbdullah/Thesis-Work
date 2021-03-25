//package blockchainv8;

import java.util.Scanner;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
public class MainClass {

    
    public static void main(String[] args) {

        BlockOperation blkOperation=new BlockOperation();
        blkOperation.addBlock("Farm");
        blkOperation.addBlock("Processor");
        blkOperation.addBlock("Distributer");
        blkOperation.addBlock("Controller");
        blkOperation.addBlock("Retailer"); //trusted block
        
        //System.out.println(timestamp());

        Scanner input=new Scanner(System.in);

        while(true){  
            System.out.println();
            System.out.println("Enter 1 to show block list");
            System.out.println("Enter 2 for transaction");
            System.out.println("Enter 3 for adding moderate block");
            System.out.println("Enter 4 for removing a block");
            System.out.println("Enter 5 for adding old block");
            System.out.println("Enter 6 for adding new block");
            System.out.println("Enter 7 for communicating with Controller");
            System.out.println("Enter 8 for removing a block from SubBlock");
            System.out.println("Enter 9 for placing order");
            
            String comm = input.nextLine();

            if(comm.equals("1")){
               
                System.out.println("Enter any Block No. & Data respectively ");
                int blk=input.nextInt();
           
                input.nextLine();
                String data=input.nextLine();
                blkOperation.getBlockChain().get(blk).setData(data);
                System.out.println();
                System.out.println(blkOperation.isChainValid());
                System.out.println();
               // blkOperation.show();
            }
            else if(comm.equals("2")){
                System.out.println("Enter known block & new block data respectively");
                String data1 = input.nextLine();
                String data2 = input.nextLine();

                try{
                    blkOperation.getBlock(data1).transection(data2);
                    System.out.println("Transaction Successfull..");
                }catch(Exception e){
                    System.err.println("Known block not found ");
                }

            }
            else if (comm.equals("3")){
                System.out.println("Enter new block & known block data respectively");
                String data1 = input.nextLine();
                String data2 = input.nextLine();

                try{
                    if(blkOperation.getBlock(data2).isMingle(data1)){
                    // Added moderate block here it's know to someone..
                    blkOperation.addBlock(data1);
                }
                else{
                    System.err.println("Data of the block is not moderate..!!");
                }
            }catch(Exception e){
                    System.err.println("Known block not found ");
                }
            }
             else if(comm.equals("4")){
                System.out.println("Enter Block data");
                String data = input.nextLine();

                blkOperation.removeBlock(data);
                // blkOperation.Data();
            }
             
            else if(comm.equals("5")){
                System.out.println("Enter old block data");
                String data = input.nextLine();

                if(blkOperation.isValid(data)){
                     blkOperation.addBlock(data);
                }
                else{
                    // block in unknown
                    System.err.println("Block data unknown!!!");
                }
                              
            }

           else if(comm.equals("6")){
                System.out.println("Enter new block data");
                String data = input.nextLine();

                blkOperation.addSubBlock(data);                
            }
           else if(comm.equals("7")){
                System.out.print("Name: ");
                String data1 = input.nextLine();

                System.out.print("Amount: ");
                String data2 = input.nextLine();

                   try{
                       blkOperation.getSubBlock(data1).SubAmount(data1,Integer.parseInt(data2));
                     
                        LocalTime start = blkOperation.getSubBlock(data1).initial_time;
                        LocalTime end = LocalTime.now();
                        long t=start.until(end, ChronoUnit.SECONDS);
                        //System.out.println("Time: "+t+" Seconds");
                       if(blkOperation.getSubBlock(data1).isOkay(data1) && t<=1000)
                       {

                        blkOperation.addBlock(data1);
                        blkOperation.deleteSubBlock(data1);
                       }
                       
                    }catch(Exception e)
                       {
                         System.err.println("Block not found ");
                       }             
            } 
            else if(comm.equals("8")){
                System.out.println("Enter subBlock data");
                String data = input.nextLine();

                blkOperation.removeSubBlock(data);
                // blkOperation.Data();
            }
            else if(comm.equals("9")){
            	System.out.print("Name: ");
            	String data1 = input.nextLine();
                System.out.print("Amount: ");
                String data2 = input.nextLine();
                     try{
                     	 blkOperation.getBlock(data1).Amount(data1,Integer.parseInt(data2));

                        // blkOperation.getBlock(data1).transection(data1);
                         //System.out.println("Amount Remaining: "+blkOperation.get)

                        LocalTime start = blkOperation.getBlock(data1).initial_time;
                        LocalTime end = LocalTime.now();
                        long t=start.until(end, ChronoUnit.SECONDS);
                        //System.out.println("Time: "+t+" Seconds"); 

                       }catch(Exception e)
                         {
                          System.err.println("Block not found ");
                         }                     
            }          
            else{
               System.err.println("Wrong Input.. !");
            }

            System.out.println();
            System.out.println();

        }
       
        
        

    }
    
}
