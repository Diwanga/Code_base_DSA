

import java.util.Arrays;

public class PriorityQueue {
  private int[] items = new int[5];
  private int count;

  // O(n)
  public void add(int item) {
    if (isFull())
      throw new IllegalStateException();

    var i = shiftItemsToInsert(item);
    items[i] = item;
    count++;
  }

  public boolean isFull() {
    return count == items.length;
  }

  private int shiftItemsToInsert(int item) {
    int i;
    for (i = count - 1; i >= 0; i--) {
      if (items[i] > item)
        items[i + 1] = items[i];
      else
        break;
    }
    return i + 1;
  }

  // O(1)
  public int remove() {
    if (isEmpty())
      throw new IllegalStateException();

    return items[--count];
  }

  public boolean isEmpty() {
    return count == 0;
  }

  @Override
  public String toString() {
    return Arrays.toString(items);
  }
}



my=============================
import java.util.Arrays;
//pRIORITY QUEUE QUEUE USING ARRAY
public class diwanga {
	
	
	int[] queue ;
	int last;
	public diwanga(int length) {
		// TODO Auto-generated constructor stub //[1 ,2 ,4 ,5, 6]
		this.queue =new int[length]; 
		last = -1;
		
	}
	
	public void enqueue(int item) {
		if(last+1 == queue.length)
			throw new IllegalStateException("Queue is FULL");
		
		if(last == -1) {
			last++;
			queue[last] = item;			
			return; 
			
		}else {
			int temp = last;
			while (temp >= 0) {
								
				if(queue[temp]<=item) {
					last++;
					queue[temp + 1] = item;	
					return;
				}
				else {
					queue[temp +1] = queue[temp];		
					
				}
				
				
				temp--;
				
			}
			
			
			
		}
				
	
	}
	
	public String displayqueue() {
   return Arrays.toString(queue);

	}
	
	public void remove() {
		if(last == -1) {
			throw new IllegalStateException("Queue is Empty");
		}
//		int remove = queue[last];
		queue[last] = 0;
		last--;
	}
	
	
	public static void main(String[] args) {
		
		diwanga diwa = new diwanga(5);
		diwa.enqueue(1);
		diwa.enqueue(4);
		diwa.enqueue(2);
		diwa.enqueue(2);
		diwa.enqueue(7);
		diwa.remove();
		diwa.remove();
		diwa.enqueue(7);
		diwa.enqueue(1);
		System.out.println(diwa.displayqueue());
		
	}

}
