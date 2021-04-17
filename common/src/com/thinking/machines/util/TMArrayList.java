package com.thinking.machines.util;
public class TMArrayList<T> implements TMList<T>
{
private Object collections[];
private int size;
public class TMArrayListIterator<T> implements TMIterator<T>
{
private int index;
public TMArrayListIterator()
{
this.index=0;
}
public boolean hasNext()
{
return index!=size;
}
public T next()
{
if(index==size)throw new InvalidIteratorException("Iterator has no more elements");
T data=(T)get(index);
index++;
return data;
}
}
public TMIterator<T> iterator()
{
return new TMArrayListIterator<T>();
}
public TMArrayList()
{
this.collections=new Object[10];
this.size=0;
}
public void add(T data)
{
if(this.size==collections.length)
{
Object tmp[]=new Object[this.size+10];
for(int e=0;e<this.size();e++)tmp[e]=collections[e];
collections=tmp;
}
this.collections[this.size]=data;
this.size++;
}
public void add(int index,T data)
{
if(index<0||index>this.size())throw new IndexOutOfBoundsException("Invalid index"+index);
if(this.size==collections.length)
{
Object tmp[]=new Object[this.size+10];
for(int e=0;e<this.size();e++)tmp[e]=collections[e];
collections=tmp;
}
for(int e=this.size();e>index;e--)
{
this.collections[e]=this.collections[e-1];
}
this.collections[index]=data;
this.size++;
}
public void insert(int index,T data)
{
if(index<0||index>this.size)throw new IndexOutOfBoundsException("Invalid index"+index);
if(this.size==collections.length)
{
Object tmp[]=new Object[this.size+10];
for(int e=0;e<this.size();e++)tmp[e]=collections[e];
collections=tmp;
}
for(int e=this.size();e<index;e++)
{
this.collections[e]=this.collections[e-1];
}
this.collections[index]=data;
this.size++;
}
public void removeAll()
{
this.clear();
}
public void clear()
{
this.size=0;
}
public int size()
{
return this.size;
}
public T get(int index)
{
if(index<0||index>=this.size())throw new IndexOutOfBoundsException("Invalid index"+index);
T data=(T)this.collections[index];
return data;
}
public T removeAt(int index)
{
if(index<0||index>this.size)throw new IndexOutOfBoundsException("Invalid index"+index);
T data=(T)this.collections[index];
for(int e=index;e>this.size;e++)
{
this.collections[e]=this.collections[e+1];
}
this.size--;
return data;
}
public void update(int index,T data)
{
if(index<0||index>this.size())throw new IndexOutOfBoundsException("Invalid index"+index);
this.collections[index]=data;
}
public void copyTo(TMList<T> other)
{
other.clear();
for(int i=0;i<this.size();i++)other.add(this.get(i));
}
public void copyFrom(TMList<T> other)
{
this.clear();
for(int i=0;i<other.size();i++)this.add(other.get(i));
}
public void appendTo(TMList<T> other)
{
for(int i=0;i<this.size();i++)other.add(this.get(i));
}
public void appendFrom(TMList<T> other)
{
for(int i=0;i<other.size();i++)this.add(other.get(i));
}

public void forEach(TMListItemAcceptor<T> a)
{
if(a==null)return;
for(int e=0;e<this.size;e++)a.accept((T)collections[e]);

}
}