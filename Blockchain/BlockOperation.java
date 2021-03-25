//package blockchainv8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


public class BlockOperation{
    
    private List<Block> blockchain=new ArrayList<>();
     private List<Block> blockchain2=new ArrayList<>();

    private HashSet<String> block = new HashSet<String>();

    
    public List<Block> getBlockChain(){
        return blockchain;  
    }

    public List<Block> getSubBlockChain(){
        return blockchain2;  
    }
    
    
    private Block getLatestBlock()
    {
        if(blockchain.isEmpty()){
            createGenesisBlock();
        }
        return blockchain.get(blockchain.size()-1);
    }
    private Block getLatestSubBlock()
    {
        if(blockchain2.isEmpty()){
            blockchain2.add(new Block(0,"Initial Data of Sub Blockchain","Initial Previous Hash of Sub Blockchain"));
        }
        return blockchain2.get(blockchain2.size()-1);
    }
    private void createGenesisBlock()
    {
        blockchain.add(new Block(0,"Initial Data","Initial Previous Hash"));
    }
    public void addBlock(String data)
    { 
        if(getBlock(data) == null){
            block.add(data);
            Block previousBlock=getLatestBlock();
            Block newBlock=new Block(previousBlock.getIndex()+1,data,previousBlock.getHash());
            blockchain.add(newBlock);
            System.out.println("Successfully Added..");
        }
        else{
            System.err.println("Block already exist!");
        }
         return;       
    }

    public void addSubBlock(String data)
    { 
        if(getSubBlock(data) == null){
            block.add(data);
            Block previousBlock=getLatestSubBlock();
            Block newBlock=new Block(previousBlock.getIndex()+1,data,previousBlock.getSubHash());
            blockchain2.add(newBlock);
            System.out.println("Successfully Added in the sub Block..");
            System.out.println();
            SubShow();
            
        }
        else{
            System.err.println("Block already exist in subBlock!");
        } 
         return;      
    }

    

    public void Data(){
         for(int i=1;i<blockchain.size();i++)
        {
            Block blk=blockchain.get(i);
                   
            System.out.println("Data of  Block "+i+": "+blk.getData());
        }
         System.out.println();
    }
    
    public void PreviousHash(){
         for(int i=1;i<blockchain.size();i++)
        {
            Block blk=blockchain.get(i);
                  
          System.out.println("Previous Hash of Block "+i+": "+blk.getPreviousHash());
        }
         System.out.println();
        
    }
    
    public void Hash(){
         for(int i=1;i<blockchain.size();i++)
        {
            Block blk=blockchain.get(i);
            
            System.out.println("Current Hash of Block "+i+": "+blk.getHash());
        }
        System.out.println();        
    }
     
    public void SubShow(){

         System.out.println();
         System.out.println("...Information of sub blockchain...");

         for(int i=1;i<blockchain2.size();i++)
        {
            Block blk=blockchain2.get(i);
            System.out.println("  Data of Block "+i+": "+blk.getData());
            System.out.println("  Hash of Block "+i+": "+blk.getSubHash());
            //System.out.println("ddd "+blk.getTransection());
            System.out.println();
        }
        System.out.println();        
    }

      public void show(){
          Data();
          PreviousHash();
          Hash();
          SubShow();

      }
   
       public void wrong()
      {
          System.err.println("Invalid Block ....");
          
      }
   
    public boolean isChainValid(){
        for(int i=1;i<blockchain.size();i++)
        {
            Block currentBlock=blockchain.get(i);
            Block previousBlock=blockchain.get(i-1);
            if(!currentBlock.getHash().equals(currentBlock.calculateHash())){
                wrong();
                return false;
               
            }
            
            //System.out.println("Hash of block "+i+": "+currentBlock.getHash());
        }
        show();
        return true;
       
    }

    public Block getBlock(String data){
        Block blk = null;
        for(int i=0;i<blockchain.size();i++){
            if(blockchain.get(i).getData().equals(data)){
                blk = blockchain.get(i);
            }
        }
        return blk;
    }

    public Block getSubBlock(String data){
        Block blk = null;
        for(int i=0;i<blockchain2.size();i++){
            if(blockchain2.get(i).getData().equals(data)){
                blk = blockchain2.get(i);
            }
        }
        return blk;
    }
    public void removeBlock(String data){
        for(int i=0;i<blockchain.size();i++){
            if(blockchain.get(i).getData().equals(data)){
                blockchain.remove(blockchain.get(i));
                System.out.println("Block Removed Successfully..");
                return;
            }
        }
        return;
    }
   public void removeSubBlock(String data){
        for(int i=0;i<blockchain2.size();i++){
            if(blockchain2.get(i).getData().equals(data)){
                blockchain2.remove(blockchain2.get(i));
                System.out.println("Block Removed from Subblock Successfully..");
                return;
            }
        }
        return;
    }
 public void deleteSubBlock(String data){
        for(int i=0;i<blockchain2.size();i++){
            if(blockchain2.get(i).getData().equals(data)){
               blockchain2.remove(blockchain2.get(i));
                System.out.println("Block deleted from Subblock Successfully..");
            }
        }
        //return;
    }

    boolean isValid(String data){
        return block.contains(data);
    }
    
}
