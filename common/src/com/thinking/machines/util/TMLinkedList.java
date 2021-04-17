package com.thinking.machines.util;
public class TMLinkedList<T> implements TMList<T>
{
class TMNode<T>
{
public T data;
public TMNode<T> next;
TMNode()
{
this.data=null;
this.next=null;
}
}
public class TMLinkedListIterator<T> implements TMIterator<T>
{
private TMNode<T> ptr;
public TMLinkedListIterator(TMNode<T> ptr)
{
this.ptr=ptr;
}
public boolean hasNext()
{
return this.ptr!=null;
}
public T next()
{
if(this.ptr==null)throw new InvalidIteratorException("Iterator has no more elements");
T data=this.ptr.data;
this.ptr=this.ptr.next;
return data;
}
}
public TMIterator<T> iterator()
{
return new TMLinkedListIterator<T>(this.start);
}
private TMNode<T> start,end;
private int size;
public TMLinkedList()
{
this.start=null;
this.end=null;
this.size=0;
}
public void add(T data)
{
TMNode<T> t=new TMNode<T>();
t.data=data;
if(this.start==null)
{
this.start=t;
this.end=t;
}
else
{
this.end.next=t;
this.end=t;
}
this.size++;
}
public void add(int index,T data)
{
if(index<0||index>this.size)throw new IndexOutOfBoundsException("Invalid index:"+index);
TMNode<T> k,p;
p=null;
k=new TMNode<T>();
k.data=data;
TMNode<T> t;
t=start;
for(int i=0;i<index;i++)
{
p=t;
t=t.next;
}
if(this.start==null)
{
this.start=k;
this.end=k;
}else
if(t==this.start)
{
k.next=this.start;
this.start=k;
}else
if(t==this.end)
{
p.next=k;
k.next=this.end;
}else
if(t==null)
{
this.end.next=k;
this.end=k;
}
else
{
p.next=k;
k.next=t;
}
this.size++;
}
public void insert(int index,T data)
{
if(index<0||index>this.size)throw new IndexOutOfBoundsException("Invalid index:"+index);
TMNode<T> k,p;
p=null;
k=new TMNode<T>();
k.data=data;
TMNode<T> t;
t=start;
for(int i=0;i<index;i++)
{
p=t;
t=t.next;
}
if(this.start==null)
{
this.start=k;
this.end=k;
}else
if(t==this.start)
{
k.next=this.start;
this.start=k;
}else
if(t==this.end)
{
p.next=k;
k.next=this.end;
}else
if(t==null)
{
this.end.next=k;
this.end=k;
}
else
{
p.next=k;
k.next=t;
}
this.size++;
}
public void removeAll()
{
this.clear();
}
public void clear()
{
this.size=0;
this.start=null;
this.end=null;
}
public int size()
{
return this.size;
}
public T get(int index)
{
if(index<0||index>this.size)throw new IndexOutOfBoundsException("Invalid index:"+index);
TMNode<T> t;
t=start;
for(int i=0;i<index;i++)
{
t=t.next;
}
return t.data;
}
public T removeAt(int index)
{
if(index<0||index>this.size)throw new IndexOutOfBoundsException("Invalid index:"+index);
TMNode p;
p=null;
TMNode<T> t;
t=start;
for(int i=0;i<index;i++)
{
p=t;
t=t.next;
}
T data=t.data;
if(t==this.start&&t==this.end)
{
this.start=null;
this.end=null;
}else
if(t==this.start)
{
this.start=this.start.next;
}else
if(t==this.end)
{
p.next=null;
this.end=p;
}
else
{
p.next=t.next;
}
this.size--;
return data;
}
public void update(int index,T data)
{
this.add(index,data);
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
TMNode<T> t;
for(t=start;t!=null;t=t.next)a.accept(t.data);
}
}