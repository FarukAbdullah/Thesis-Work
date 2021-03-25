//package blockchainv8;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Set;


public class Block {
    private int index;
    private Long timestamp;
    private String data;
    private String previousHash;
    private String hash;
    private String subhash;
    private int transection=0;
    private int count=0;
    public int amount=1000;
    public LocalTime initial_time;

    // Relation mapping
    private HashSet<String> hs = new HashSet<String>();
    private HashSet<String> subhs = new HashSet<String>();

   
public Block(int index,String data, String previousHash) {
    this.index = index;
    this.data=data;
    this.previousHash = previousHash;
    this.timestamp=System.currentTimeMillis();
    this.hash= calculateHash();
    this.subhash=calculateSubHash();   
    this.initial_time = LocalTime.now(); 
    }
    
    
public void setIndex(int index)
    {
        this.index=index;
    }
public void setTimestamp(Long timestamp)
    {
        this.timestamp=timestamp;
    }
public void setPreviousHash(String previousHash)
    {
        this.previousHash=previousHash;
    }
public void setHash(String hash)
    {
        this.hash=hash;
    }
public void setData(String data)
    {
        this.data=data;
    }
public void setsubHash(String subhash)
    {
        this.subhash=subhash;
    }
public void setTransection(int transection)
    {
        this.transection=transection;
    }
  public void setAmount(int amount)
    {
        this.amount=amount;
    }
    
public int getAmount()
    {
        return amount;
    }
    
    
public String getData()
    {
        return data;
    }
    
public int getIndex()
    {
        return index;
    }
public int getTransection()
    {
        return transection;
    }
public Long getTimestamp()
    {
        return timestamp;
    }
    
public String getPreviousHash()
    {
        return previousHash;
    }
public String getHash()
    {
        return hash;
    }
public String getSubHash()
    {
        return subhash;
    }

    
   
    
 public String calculateHash(){
        String text=String.valueOf(index + previousHash + String.valueOf(timestamp)+ String.valueOf(data));
        MessageDigest digest=null;
        try{
            digest=MessageDigest.getInstance("SHA-256");
        }
        catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        
        final byte bytes[]=digest.digest(text.getBytes());
        final StringBuilder hexString =new StringBuilder();
        for(final byte b:bytes)
        {
            String hex=Integer.toHexString(0xff &b);
            if(hex.length()==1){
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
 public String calculateSubHash(){
        String text=String.valueOf(String.valueOf(timestamp)+ String.valueOf(data));
        MessageDigest digest=null;
        try{
            digest=MessageDigest.getInstance("SHA-256");
        }
        catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        
        final byte bytes[]=digest.digest(text.getBytes());
        final StringBuilder hexString =new StringBuilder();
        for(final byte b:bytes)
        {
            String hex=Integer.toHexString(0xff &b);
            if(hex.length()==1){
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

public void transection(String data){
    
        hs.add(data);
        count++;
        System.out.println("Transection: "+count);
        return;
    }

  public void Amount(String data,int amont)
   {
   	 long startTime = System.currentTimeMillis();
   	if(amont<1000)
   	{for(int i=1;i<=amont;i++){
   		
   		amount-=1;
   		
   		}
   		System.out.println("Remaining: "+amount);
   		System.out.println("Oder Delivery Process: ");
   		System.out.println("Retrailer  ---> Controller");
   		System.out.println("Controller ---> Farm");
   		System.out.println("Farm       ---> Controller");
   		System.out.println("Controller ---> Retrailer");
   		transection(data);


   	}
   	else
   	{
   		System.out.println("Insuffient Amount");

   	}
   	 long stopTime = System.currentTimeMillis();
      long elapsedTime = stopTime - startTime;
      System.out.println("Time Spend: "+elapsedTime);
   	return ;
   }

public void SubAmount(String data,int amont)
   {
   	 long startTime = System.currentTimeMillis();
   	if(amont<1000)
   	{for(int i=1;i<=amont;i++){
   		
   		amount-=1;
   		
   		}
   		System.out.println("Remaining: "+amount);
   		System.out.println("Oder Delivery Process: ");
   		System.out.println("Retrailer  ---> Controller");
   		System.out.println("Controller ---> Farm");
   		System.out.println("Farm       ---> Controller");
   		System.out.println("Controller ---> Retrailer");
   		subtransection(data);


   	}
   	else
   	{
   		System.out.println("Insuffient Amount");

   	}
   	 long stopTime = System.currentTimeMillis();
      long elapsedTime = stopTime - startTime;
      System.out.println("Time Spend: "+elapsedTime);
   	return ;
   }

public void subtransection(String data){
        hs.add(data);
        transection++;
        System.out.println("Transection: "+transection);
        if(transection>=3)
        {
            subhs.add(data);
        }
        
        return;
    }
     
    public boolean isOkay(String data)
    {
       return subhs.contains(data);
    }

    public boolean isMingle(String data){
        return hs.contains(data);
    }
}
