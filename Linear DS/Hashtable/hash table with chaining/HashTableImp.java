/*********************************************
 
	* CO322: Data structures and algorithms
 
	* Implementation of the hashTable
	 
	* E/16/025
	* Amasith K.T.D
	*chaining
 *********************************************/


public class HashTableImp implements HashTable
{
   private static class BucketNode 
   {
      String key;
      int value=0;
      BucketNode next;  //to get pointer to next node in the list;
   }

   public BucketNode[] table;  //to hold  hash table                         
   private int entryCount;  //to hold number of (key,value) pairs in the hash table                   
   
   public HashTableImp(int Buckets) 
   {
      if(Buckets <= 0) throw new IllegalArgumentException("table size should be positive");
      	table = new BucketNode[Buckets];
   }
   
   
   public void insert(String key) 
   {   
         
      int bucket = hash(key); // get index of the bucketarray for given key     
      BucketNode list=null;   //for new node
      
      try{
    	  list = table[bucket]; //to traversing linked list}
      
      }catch(ArrayIndexOutOfBoundsException e) {wd
    	  System.out.println(bucket);
      }
                              
      while (list != null) 
      {
        
         if (list.key.equals(key))  //Search the nodes which key already exists.//check duplicates
            break;
         list = list.next;
      }
      
      if (list != null) //key is exist in hash table
      {
                
         list.value++;  //Update value by incrementing one
      }
      else  // key doesen't exist in hash table
      { 
         BucketNode newNode = new BucketNode(); // making new node for insert
         newNode.key = key;
         newNode.value++;
         newNode.next = table[bucket];
         table[bucket] = newNode;
         entryCount++;  //counting entries.
      }
   }

   
   //To get value(no of presents of key in given file) for given key 
   public int search(String key) 
   {   
      int bucket = hash(key); // get index of the bucketarray for given key     
      BucketNode list = table[bucket]; //getting relavant bucketnode for traverse
      
      while (list != null)  //traversing
      {                 
         if (list.key.equals(key)) //key is exist
            return list.value; 
         list = list.next;
      }
      
      //key does not exists returning 0
      return 0;  
   }
   
   //Compute a hash code for the given key 
   //return index value genarated with hash function  
   private int hash(String key) 
   {
	   int h = 0;
	   for (int i = 0; i < key.length(); i++)
	   {
		   h = (29* h + key.charAt(i))%table.length;		   
	   }	   
	   return h%table.length;  //mapping to table length 
   }
   
   //finding existance of the key
   public boolean containsKey(String key) 
   {      
      return search(key)>0; 
   }
   
   // to get no of entriens in one bucket
   public void hashTableInfo(int length)  
   {
         
	   int dev=0;
	   int sum = 0;
           int min = Integer.MAX_VALUE;
           int max = -1;
	   for(int i=0;i<length;i++)
	   { 		
		   int counter=0;
		   BucketNode list = table[i];
		   while(list != null)
		   {		 
			   list = list.next;
			   counter++;    // getting sum keys in bucket
		   }
                   if(counter > max){
                           max = counter;
                   }
                   if(counter < min){
                           min = counter;
                   }
		   sum=sum+counter;   // getting sum keys in table
		   dev=dev+(int) Math.pow(counter,2); // getting deviation
		   //System.out.println(counter);
		   System.out.println("BUCKET "+(i+1)+" : "+counter);
	   }	
	   
	   float avg = (float)(sum/(float)length); //getting average
	   float var = (float)(dev/length) - (float)(Math.pow(avg, 2));//getting varience
	   System.out.println("\n\nMin keys in bucket : "+min);
       System.out.println("Max keys in bucket : "+max);
	   System.out.println("Total keys : "+sum);
	   System.out.println("Avg keys in one bucket:"+avg);
	   System.out.println("Deviation of the keys in buckets:"+Math.sqrt(var));
          
   }
   
   //to get entry count in hash table
   public int getSize() 
   {
      return entryCount;
   }
}// end HashTableImp 
