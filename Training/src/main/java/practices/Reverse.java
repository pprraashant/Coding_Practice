package practices;
class Reverse
{
	public static void main(String []args)
	{
		String str= "My Name is Prashant";
		char [] strchar= new char[20];
		int j=0;
		stack sk=new stack();
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i)== ' ')
			{
				j=0;
				sk.push(strchar.toString());
			}
			else
			{
				strchar[j++]=str.charAt(i);
			}
		}
		
		System.out.println(""+sk.pop()+sk.pop()+sk.pop());
		
	}
}
class stack
{
	String str [] ;
	static int i=0;
	stack()
	{
		str=new String[20];
	}
	stack(String str)
	{
		this.str[i++]=str;
	}
	
	public void push(String str)
	{
		this.str[i++]=str;
	}
	public String pop()
	{
		return this.str[--i].toString();
	}
}