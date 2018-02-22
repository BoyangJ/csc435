package Environment;

public class ListEnvironment<K,V> implements Environment<K,V>
{
	ListNode<K,V> head;
	int	scopeLevel;

	public ListEnvironment()
	{
		head = null;
		scopeLevel = 0;
	}

	public void beginScope()
	{
		scopeLevel++;
	}

	public void endScope()
	{
		ListNode<K,V> prev = null;
		ListNode<K,V> curr = head;

		while (curr != null)
		{
			// purge all items in the current scopep
			if (curr.scope == scopeLevel)
			{
				if (curr == head)
				{
					head = curr.next;
				}
				else 
				{
					prev.next = curr.next;
				}
			}
			prev = curr;
			curr = curr.next;
		}

		scopeLevel--;
	}

	public boolean inCurrentScope(K key)
	{
		ListNode<K,V> p = head;
		while (p != null)
		{
			if (key.equals(p.key) && p.scope == scopeLevel)
			{
				return true;
			}
			p = p.next;
		}

		return false;
	}

	public void add(K key, V value)
	{
		ListNode<K,V> newNode = new ListNode<K,V>(key, value, scopeLevel, head);
		head = newNode;
	}

	public V lookup(K key)
	{
		ListNode<K,V> p = head;
		while (p != null)
		{
			if (key.equals(p.key) && p.scope == scopeLevel)
			{
				return p.value;
			}
			p = p.next;
		}

		return null;
	}

	public String toString()
	{
		ListNode<K,V> n = head;
		String s = "lvl: " + scopeLevel + " {";
		while (n != null)
		{
			s += "(";
			if ( n.key == null )
			{
				s += "<sm>";
			}
			else
			{
				s += n.key + "," + n.value + "," + n.scope;
			}
			s += ")";
			if (n.next != null)
			{
				s += ",";
			}
			n = n.next;
		}
		s += "}";
		return s;
	}
}
