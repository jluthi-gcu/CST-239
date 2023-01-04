package app;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class InventoryList<T>{

	private List<T> list = new ArrayList<T>();

	public void add(T obj) {
	 
		list.add(obj);
		
	}
	
	public T get(int i) {
		
		return list.get(i);
	}
	
	public void remove(T obj) {
		
		list.remove(obj);
	}
	
	public void remove(int index) {
		
		list.remove(index);
	}
	
	public int size() {
		
		return list.size();
	}
	
	
	public void sort(boolean descending) {
		
		Collections.sort(list, new Comparator<Object>() {
			
			public int compare(Object o1, Object o2) {
		
				int	compare = ((SalableProduct)o1).getName().toLowerCase().compareTo(((SalableProduct)o2).getName().toLowerCase());
				
				if (descending)
					compare = compare * -1;
				
				//If different by name return.
				if (compare != 0)
					return compare;
				
				
				float o1Price = ((SalableProduct)o1).getPrice();
				float o2Price = ((SalableProduct)o2).getPrice();
				
				if (descending == false) {
					
					if (o1Price < o2Price)
						return -1;
			
					if (o1Price > o2Price)
						return 1;
						
				}else {
					
					if (o1Price < o2Price)
						return 1;
			
					if (o1Price > o2Price)
						return -1;
						
					
				}
				
			
				return 0;	
				
			}

		
			
		});
	}
	
}
