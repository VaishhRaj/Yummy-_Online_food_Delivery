package com.food.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
	private Map<Integer,CartItem> items;
	static double total=0.0;
	public Cart()
	{
		this.items=new HashMap<>();
	}
	public double addItem(CartItem item)
	{
		int itemId=item.getItemId();
		if(items.containsKey(itemId))
		{
			CartItem existingItem=items.get(itemId);
			existingItem.setQuantity(existingItem.getQuantity()+item.getQuantity());
			
		}
		else {
			items.put(itemId,item);
		}
		total=items.get(itemId).getQuantity() * items.get(itemId).getPrice();
		return total;
	}
	public double updateItem(int itemId,int quantity)
	{
		
		if(items.containsKey(itemId))
		{
			if(quantity<=0)
				items.remove(itemId);
			else
			{
				items.get(itemId).setQuantity(quantity);
				total=items.get(itemId).getQuantity() * items.get(itemId).getPrice();
			}
		}
		return total;
		
	}
	public void removeItem(int itemId)
	{
		items.remove(itemId);
	}
	public Map<Integer,CartItem> getItems()
	{
		return items;
	}
	public void clear()
	{
		items.clear();
	}
}
