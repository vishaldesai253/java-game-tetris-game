import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class TetrisGame extends JFrame implements KeyListener,ActionListener,ItemListener,FocusListener
{
	JPanel p1,p2;
	int x=200,y=30,w=20,z=0;
	JButton b1,b2,b3;
	JButton bstart,bpause,bexit;
	boolean start=false,pause=true,focus=true,over=false;
	int sleep=0,score=0;
	Label l2,l3;
	Label l1;
	Font f;
	JComboBox jc;
	int lshape=0,ishape=0,bshape=0,gshape=0,pshape=0,sshape=0,oshape=0;
	TetrisGame()
	{
		super("GAME");
		
		setLayout(null);
	
		p1=new JPanel();
		p2=new JPanel();
		
		p1.setLayout(null);
		p2.setLayout(null);
		
		p1.setBounds(100,50,500,620);
		p1.setBackground(Color.white);
		
		p2.setBounds(800,50,200,200);
		p2.setBackground(Color.cyan);
		
		f=new Font("Times New Roman",Font.BOLD,32);
		l1=new Label("SCORE",Label.CENTER);
		l1.setFont(f);
		l1.setBackground(Color.green);
		l1.setBounds(0,0,200,100);
		
		l2=new Label("0",Label.CENTER);
		l2.setFont(f);
		l2.setBackground(Color.cyan);
		l2.setBounds(0,100,200,100);
		
		l3=new Label("GAME OVER",Label.CENTER);
		f=new Font("Times New Roman",Font.BOLD,48);
		l3.setFont(f);
		l3.setBackground(Color.white);
		l3.setForeground(Color.red);
		l3.setBounds(250,300,300,300);
		add(l3);
		l3.setVisible(false);
		p2.add(l1);
		p2.add(l2);
			
		b1=new JButton();
		b1.setBounds(0,600,500,20);
		
		b2=new JButton();
		b2.setBounds(89,50,10,620);
		
		b3=new JButton();
		b3.setBounds(601,50,10,620);
		
		bstart=new JButton("START");
		bstart.setBounds(750,400,100,50);
		
		bpause=new JButton("PAUSE");
		bpause.setBounds(850,400,100,50);
		
		bexit=new JButton("EXIT");
		bexit.setBounds(950,400,100,50);
		
		bstart.addActionListener(this);
		bpause.addActionListener(this);
		bexit.addActionListener(this);
		
		jc=new JComboBox();
		for(int i=1;i<=5;i++)
			jc.addItem("Level "+i);
		jc.setBounds(1050,400,100,50);
		jc.addFocusListener(this);
		add(jc);
		
		add(p2);
		add(b2);
		add(b3);
		add(bstart);
		add(bpause);
		add(bexit);
		p1.add(b1);
		add(p1);
		addKeyListener(this);
		setVisible(true);
		setSize(1366,768);
		while(true)
		{
			
			if(focus)
			requestFocus();
			if(start)
			{
			int i=(int)(Math.random()*7);
			if(i==0)
			bshape();
			if(i==1)
			lshape();
			if(i==2)
			ishape();
			if(i==3)
			gshape();
			if(i==4)
			sshape();
			if(i==5)
			pshape();
			if(i==6)
				oshape();
		int i1=0,j=0;
			over=false;
		for(int t=0;t<500;t++)
		{
			if(p1.getComponentAt(t,60)instanceof JButton)
			{
				l3.setVisible(true);
				over=true;
				break;
			}
		}
			if(over) break;
		
		for(int n=580;n>200;n-=20)
		{
			for( i1=0,j=n;i1<500;i1+=20)
			{
				try{
				JButton b=(JButton)p1.getComponentAt(i1,j);
				}
				catch(Exception e)
				{
					break;
				}
			}
			if(i1==500)
			{
				l2.setText(""+(score+=100));
				for( i1=0,j=n;i1<500;i1+=20)
				{
					JButton b=(JButton)p1.getComponentAt(i1,j);
					p1.remove(b);
					p1.repaint();
				}
				
				int l=p1.getComponents().length;
				Component b[]=p1.getComponents();
				for(int t=0;t<l;t++)
				{
					if(b[t].getLocation().y<=n)
					b[t].setLocation(b[t].getLocation().x,b[t].getLocation().y+w);
				}
			}
		}		
		}}
	}

	public void lshape()
	{
			x=200;y=40;
			z=1;sleep=400;
			boolean flag=true;
			JButton b[]=new JButton[4];
			int w=20,h=20;
			for(int i=0;i<4;i++)
			{
				b[i]=new JButton();
				b[i].setBackground(Color.yellow);
			}
			for(int i=0;i<4;i++)
				p1.add(b[i]);

			while(flag)
			{
				requestFocus();
				if(pause)
				{
				
				y+=20;
				lshape=z;
				if(lshape==1)
				{
					if(x==0)
						x+=20;
					b[0].setBounds(x,y,w,w);
					b[1].setBounds(x-w,y,w,w);
					b[2].setBounds(x-w,y-w,w,w);
					b[3].setBounds(x-w,y-w-w,w,w);
					if(p1.getComponentAt(x,y+w)instanceof JButton||p1.getComponentAt(x-w,y+w)instanceof JButton)
						flag=false;
					
				}
				if(lshape==2)
				{
					if(x==0)
						x+=20;
					if(x==480)
						x-=20;
					b[0].setBounds(x-w,y,w,w);
					b[1].setBounds(x-w,y-w,w,w);
					b[2].setBounds(x,y-w,w,w);
					b[3].setBounds(x+w,y-w,w,w);
					if(p1.getComponentAt(x-w,y+w)instanceof JButton||p1.getComponentAt(x,y)instanceof JButton||p1.getComponentAt(x+w,y)instanceof JButton)
						flag=false;
					
				}
				if(lshape==3)
				{
					if(x==0)
						x+=20;
					b[3].setBounds(x,y,w,w);
					b[2].setBounds(x,y-w,w,w);
					b[1].setBounds(x,y-w-w,w,w);
					b[0].setBounds(x-w,y-w-w,w,w);
					if(p1.getComponentAt(x-w,y-w)instanceof JButton||p1.getComponentAt(x,y+w)instanceof JButton)
						flag=false;
				}
				if(lshape==4)
				{
					if(x==0)
						x+=20;
					if(x==480)
						x-=20;
					b[3].setBounds(x-w,y,w,w);
					b[2].setBounds(x,y,w,w);
					b[1].setBounds(x+w,y,w,w);
					b[0].setBounds(x+w,y-w,w,w);
					if(p1.getComponentAt(x+w,y+w)instanceof JButton||p1.getComponentAt(x,y+w)instanceof JButton||p1.getComponentAt(x-w,y+w)instanceof JButton)
						flag=false;
				}
				if(!flag)
					lshape=0;
				try{
					Thread.sleep(sleep);
				}
				catch(Exception e){}
			}
			}
	}
	public void oshape()
	{
			x=200;y=40;
			z=1;sleep=400;
			boolean flag=true;
			JButton b[]=new JButton[4];
			int w=20,h=20;
			for(int i=0;i<4;i++)
			{
				b[i]=new JButton();
				b[i].setBackground(Color.orange);
			}
			for(int i=0;i<4;i++)
				p1.add(b[i]);

			while(flag)
			{
				requestFocus();
				if(pause)
				{
				
				y+=20;
				oshape=z;
				if(oshape==2)
				{
					if(x==0)
						x+=20;
					if(x==500)
						x-=20;
					b[0].setBounds(x,y-w,w,w);
					b[1].setBounds(x,y,w,w);
					b[2].setBounds(x,y+w,w,w);
					b[3].setBounds(x-w,y,w,w);
					if(p1.getComponentAt(x-w,y+w)instanceof JButton||p1.getComponentAt(x,y+w+w)instanceof JButton)
						flag=false;
					
				}
				if(oshape==1)
				{
					if(x==0)
						x+=20;
					if(x==480)
						x-=20;
					if(x==500)
						x-=40;
					b[0].setBounds(x-w,y,w,w);
					b[1].setBounds(x,y,w,w);
					b[2].setBounds(x+w,y,w,w);
					b[3].setBounds(x,y+w,w,w);
					if(p1.getComponentAt(x-w,y+w)instanceof JButton||p1.getComponentAt(x,y+w+w)instanceof JButton||p1.getComponentAt(x+w,y+w)instanceof JButton)
						flag=false;
					
				}
				if(oshape==3)
				{
					if(x==0)
						x+=20;
					if(x==480)
						x-=20;
					if(x==500)
						x-=40;
					b[3].setBounds(x,y-w,w,w);
					b[2].setBounds(x-w,y,w,w);
					b[1].setBounds(x,y,w,w);
					b[0].setBounds(x+w,y,w,w);
					if(p1.getComponentAt(x-w,y+w)instanceof JButton||p1.getComponentAt(x,y+w)instanceof JButton||p1.getComponentAt(x+w,y+w)instanceof JButton)
						flag=false;
				}
				if(oshape==4)
				{
					if(x==0)
						x+=20;
					if(x==500)
						x-=20;
					b[3].setBounds(x,y,w,w);
					b[2].setBounds(x-w,y-w,w,w);
					b[1].setBounds(x-w,y,w,w);
					b[0].setBounds(x-w,y+w,w,w);
					if(p1.getComponentAt(x-w,y+w+w)instanceof JButton||p1.getComponentAt(x,y+w)instanceof JButton)
						flag=false;
				}
				if(!flag)
					oshape=0;
				try{
					Thread.sleep(sleep);
				}
				catch(Exception e){}
			}
			}
	}
	
	public void ishape()
	{
			x=200;y=40;
			z=1;sleep=400;
			boolean flag=true;
			JButton b[]=new JButton[4];
			int w=20,h=20;

			for(int i=0;i<4;i++)
			{
				b[i]=new JButton();
				b[i].setBackground(Color.red);
			}
			for(int i=0;i<4;i++)
				p1.add(b[i]);
			while(flag)
			{
				requestFocus();
				if(pause)
				{
				y+=20;
				if(z==1||z==3)
				ishape=1;
				else
					ishape=2;
				if(ishape==1)
				{
					if(x==0)
						x+=40;
					if(x==20)
						x+=20;
					
					if(x==480)
						x-=20;
				//	if()
					b[0].setBounds(x-w-w,y,w,w);
					b[1].setBounds(x-w,y,w,w);
					b[2].setBounds(x,y,w,w);
					b[3].setBounds(x+w,y,w,w);
					if(p1.getComponentAt(x-w-w,y+w)instanceof JButton||p1.getComponentAt(x-w,y+w)instanceof JButton||p1.getComponentAt(x,y+w)instanceof JButton||p1.getComponentAt(x+w,y+w)instanceof JButton)
						flag=false;
					
				}
				if(ishape==2)
				{
					if(y>560)
						y=560;
					
					b[0].setBounds(x,y-w-w,w,w);
					b[1].setBounds(x,y-w,w,w);
					b[2].setBounds(x,y,w,w);
					b[3].setBounds(x,y+w,w,w);
					if(p1.getComponentAt(x,y+w+w)instanceof JButton)
						flag=false;
				}
				if(!flag)
					ishape=0;
				try{
					Thread.sleep(sleep);
				}
				catch(Exception e){}
			}
			}
	}
	public void sshape()
	{
			x=200;y=40;
			z=1;sleep=400;
			sshape=1;
			boolean flag=true;
			JButton b[]=new JButton[4];
			int w=20,h=20;

			for(int i=0;i<4;i++)
			{
				b[i]=new JButton();
				b[i].setBackground(Color.cyan);
				p1.add(b[i]);
			}
		
				
			while(flag)
			{
				requestFocus();
				if(pause)
				{
				
				y+=20;
				
					if(x==0)
						x+=20;
					if(x==500)
						x-=20;
					if(sshape==1)
				{
					b[0].setBounds(x-w,y-w,w,w);
					b[1].setBounds(x,y-w,w,w);
					b[2].setBounds(x-w,y,w,w);
					b[3].setBounds(x,y,w,w);
					if(p1.getComponentAt(x-w,y+w)instanceof JButton||p1.getComponentAt(x,y+w)instanceof JButton)
						flag=false;
				}
				if(!flag)
					sshape=0;
				try{
					Thread.sleep(sleep);
				}
				catch(Exception e){}
			}
			}
	}
	
	public void bshape()
	{
			x=200;y=40;
			z=1;sleep=400;
			boolean flag=true;
			JButton b[]=new JButton[4];
			int w=20,h=20;

			for(int i=0;i<4;i++)
			{
				b[i]=new JButton();
				b[i].setBackground(Color.blue);
			}
			for(int i=0;i<4;i++)
				p1.add(b[i]);
			while(flag)
			{
				requestFocus();
				if(pause)
				{
				
				if(z==1||z==3)
					bshape=1;
				else
					bshape=2;
				y+=20;
				if(bshape==1)
				{
					if(x==0)
						x+=20;
					
					b[0].setBounds(x,y-w,w,w);
					b[1].setBounds(x,y,w,w);
					b[2].setBounds(x-w,y,w,w);
					b[3].setBounds(x-w,y+w,w,w);
					if(p1.getComponentAt(x,y+w)instanceof JButton||p1.getComponentAt(x-w,y+w+w)instanceof JButton)
						flag=false;
				}
				if(bshape==2)
				{
					if(x==0)
					x+=20;
				
				
				if(x==500-20)
						x-=20;
					b[0].setBounds(x+w,y,w,w);
					b[1].setBounds(x,y,w,w);
					b[2].setBounds(x,y-w,w,w);
					b[3].setBounds(x-w,y-w,w,w);
					if(p1.getComponentAt(x+w,y+w)instanceof JButton||p1.getComponentAt(x,y+w)instanceof JButton||p1.getComponentAt(x-w,y)instanceof JButton)
						flag=false;
				}
				if(!flag)
					bshape=0;
				try{
					Thread.sleep(sleep);
				}
				catch(Exception e){}
			}}
	}
	
	public void gshape()
	{
			x=200;y=40;
			z=1;sleep=400;
			boolean flag=true;
			JButton b[]=new JButton[4];
			int w=20,h=20;
			for(int i=0;i<4;i++)
			{
				b[i]=new JButton();
				b[i].setBackground(Color.green);
			}
			for(int i=0;i<4;i++)
				p1.add(b[i]);
			while(flag)
			{
				requestFocus();
				if(pause)
				{
				
				if(z==1||z==3)
					gshape=1;
				else
					gshape=2;
				y+=20;
				if(gshape==1)
				{
					if(x==0)
						x=20;
					b[0].setBounds(x-w,y-w,w,w);
					b[1].setBounds(x-w,y,w,w);
					b[2].setBounds(x,y,w,w);
					b[3].setBounds(x,y+w,w,w);
					if(p1.getComponentAt(x,y+w+w)instanceof JButton||p1.getComponentAt(x-w,y+w)instanceof JButton)
						flag=false;
				}
				if(gshape==2)
				{
					if(x==0)
						x=20;
					if(x==500-20)
						x-=20;
					b[0].setBounds(x+w,y,w,w);
					b[1].setBounds(x,y,w,w);
					b[2].setBounds(x,y+w,w,w);
					b[3].setBounds(x-w,y+w,w,w);
					if(p1.getComponentAt(x+w,y+w)instanceof JButton||p1.getComponentAt(x,y+w+w)instanceof JButton||p1.getComponentAt(x-w,y+w+w)instanceof JButton)
						flag=false;
				}
				if(!flag)
					gshape=0;
				
				try{
					Thread.sleep(sleep);
				}
				catch(Exception e){}
			}}
	}
	
	public void pshape()
	{
			x=200;y=40;
			z=1;sleep=400;
			boolean flag=true;
			JButton b[]=new JButton[4];
			int w=20,h=20;
			for(int i=0;i<4;i++)
			{
				b[i]=new JButton();
				b[i].setBackground(new Color(215,119,225));
			}
			for(int i=0;i<4;i++)
				p1.add(b[i]);
			while(flag)
			{
				requestFocus();
				if(pause)
				{
				
				pshape=z;
				y+=20;
				if(pshape==1)
				{
					if(x==0)
						x+=20;
					b[0].setBounds(x-w,y+w,w,w);
					b[1].setBounds(x,y+w,w,w);
					b[2].setBounds(x,y,w,w);
					b[3].setBounds(x,y-w,w,w);
					if(p1.getComponentAt(x-w,y+w+w)instanceof JButton||p1.getComponentAt(x,y+w+w)instanceof JButton)
						flag=false;
				}
				if(pshape==2)
				{
					if(x==0)
						x+=20;
					if(x==500-20)
						x-=20;
					if(y>560)
						y=560;
					b[0].setBounds(x-w,y-w,w,w);
					b[1].setBounds(x-w,y,w,w);
					b[2].setBounds(x,y,w,w);
					b[3].setBounds(x+w,y,w,w);
					if(p1.getComponentAt(x-w,y+w)instanceof JButton||p1.getComponentAt(x,y+w)instanceof JButton||p1.getComponentAt(x+w,y+w)instanceof JButton)
						flag=false;
				}
				if(pshape==3)
				{
					if(x==500-20)
						x-=20;
					b[3].setBounds(x,y+w,w,w);
					b[2].setBounds(x,y,w,w);
					b[1].setBounds(x,y-w,w,w);
					b[0].setBounds(x+w,y-w,w,w);
					if(p1.getComponentAt(x,y+w+w)instanceof JButton||p1.getComponentAt(x+w,y)instanceof JButton)
						flag=false;
				}
				if(pshape==4)
				{
					if(x==0)
						x+=20;
					if(x==500-20)
						x-=20;
					b[3].setBounds(x-w,y,w,w);
					b[2].setBounds(x,y,w,w);
					b[1].setBounds(x+w,y,w,w);
					b[0].setBounds(x+w,y+w,w,w);
					if(p1.getComponentAt(x+w,y+w+w)instanceof JButton||p1.getComponentAt(x,y+w)instanceof JButton||p1.getComponentAt(x-w,y+w)instanceof JButton)
						flag=false;
				}
				if(!flag)
					pshape=0;
				try{
					Thread.sleep(sleep);
				}
				catch(Exception e){}
			}
	}}
	
	public void keyPressed(KeyEvent e)
	{
		if(e.getKeyCode()==KeyEvent.VK_UP)
		{
			z++;
			if(z>4)
			{
				z=1;
			}
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT)
		{
			if(x>0)
			{
				if(ishape==1)
				{
					if(!(p1.getComponentAt(x-w-w-w,y+w)instanceof JButton))
						x-=w;
				}
				if(ishape==2)
				{
					if(!(p1.getComponentAt(x-w,y+w+w)instanceof JButton||p1.getComponentAt(x-w,y+w)instanceof JButton||p1.getComponentAt(x-w,y)instanceof JButton||p1.getComponentAt(x-w,y-w)instanceof JButton))
						x-=w;
				}
				
				if(lshape==1)
				{
					if(!(p1.getComponentAt(x-w-w,y+w)instanceof JButton||p1.getComponentAt(x-w-w,y)instanceof JButton||p1.getComponentAt(x-w-w,y-w)instanceof JButton))
						x-=w;
				}
				if(lshape==2)
				{
					if(!(p1.getComponentAt(x-w-w,y+w)instanceof JButton||p1.getComponentAt(x-w-w,y)instanceof JButton))
						x-=w;
				}
				if(lshape==3)
				{
					if(!(p1.getComponentAt(x-w,y+w)instanceof JButton||p1.getComponentAt(x-w-w,y-w)instanceof JButton))
						x-=w;
				}
				if(lshape==4)
				{
					if(!(p1.getComponentAt(x-w-w,y+w)instanceof JButton||p1.getComponentAt(x,y-w)instanceof JButton))
						x-=w;
				}
				if(pshape==1)
				{
					if(!(p1.getComponentAt(x-w-w,y+w+w)instanceof JButton||p1.getComponentAt(x-w,y)instanceof JButton))
						x-=w;
				}
				if(pshape==2)
				{
					if(!(p1.getComponentAt(x-w-w,y+w)instanceof JButton||p1.getComponentAt(x-w-w,y)instanceof JButton))
						x-=w;
				}
				if(pshape==3)
				{
					if(!(p1.getComponentAt(x-w,y)instanceof JButton||p1.getComponentAt(x-w,y+w)instanceof JButton||p1.getComponentAt(x-w,y+w+w)instanceof JButton))
						x-=w;
				}
				if(pshape==4)
				{
					if(!(p1.getComponentAt(x-w-w,y+w)instanceof JButton||p1.getComponentAt(x,y+w+w)instanceof JButton))
						x-=w;
				}
				if(bshape==1)
				{
					if(!(p1.getComponentAt(x-w-w,y+w)instanceof JButton||p1.getComponentAt(x-w-w,y+w+w)instanceof JButton))
						x-=w;
				}
				if(bshape==2)
				{
					if(!(p1.getComponentAt(x-w-w,y)instanceof JButton||p1.getComponentAt(x-w,y+w)instanceof JButton))
						x-=w;
				}
				if(gshape==1)
				{
					if(!(p1.getComponentAt(x-w,y+w+w)instanceof JButton||p1.getComponentAt(x-w-w,y+w)instanceof JButton))
						x-=w;
				}
				if(gshape==2)
				{
					if(!(p1.getComponentAt(x-w-w,y+w+w)instanceof JButton))
						x-=w;
				}
				if(sshape==1)
				{
					if(!(p1.getComponentAt(x-w-w,y+w)instanceof JButton||p1.getComponentAt(x-w-w,y)instanceof JButton))
						x-=w;
				}
				if(oshape==1)
				{
					if(!(p1.getComponentAt(x-w-w,y+w)instanceof JButton||p1.getComponentAt(x-w,y+w+w)instanceof JButton))
						x-=w;
				}
				if(oshape==2)
				{
					if(!(p1.getComponentAt(x-w-w,y+w)instanceof JButton||p1.getComponentAt(x-w,y+w+w)instanceof JButton))
						x-=w;
				}
				if(oshape==3)
				{
					if(!(p1.getComponentAt(x-w-w,y+w)instanceof JButton))
						x-=w;
				}
				if(oshape==4)
				{
					if(!(p1.getComponentAt(x-w-w,y)instanceof JButton||p1.getComponentAt(x-w-w,y+w)instanceof JButton||p1.getComponentAt(x-w-w,y+w+w)instanceof JButton))
						x-=w;
				}
				
			}
		}
		
		if(e.getKeyCode()==KeyEvent.VK_RIGHT)
		{
			if(x<500-20)
			{
				if(ishape==1)
				{
					if(!(p1.getComponentAt(x+w+w,y+w)instanceof JButton))
						x+=w;
				}
				if(ishape==2)
				{
					if(!(p1.getComponentAt(x+w,y+w+w)instanceof JButton||p1.getComponentAt(x+w,y+w)instanceof JButton||p1.getComponentAt(x+w,y)instanceof JButton||p1.getComponentAt(x+w,y-w)instanceof JButton))
						x+=w;
				}
				if(lshape==1)
				{
					if(!(p1.getComponentAt(x+w,y+w)instanceof JButton||p1.getComponentAt(x,y-w)instanceof JButton))
					{	
						x+=w;
					}
				}	
				if(lshape==2)
				{
					if(!(p1.getComponentAt(x,y+w)instanceof JButton||p1.getComponentAt(x+w+w,y)instanceof JButton))
						x+=w;
				}
				if(lshape==3)
				{
					if(!(p1.getComponentAt(x+w,y+w)instanceof JButton||p1.getComponentAt(x+w,y)instanceof JButton||p1.getComponentAt(x+w,y-w)instanceof JButton))
						x+=w;
				}
				if(lshape==4)
				{
					if(!(p1.getComponentAt(x+w+w,y+w)instanceof JButton||p1.getComponentAt(x+w+w,y)instanceof JButton))
						x+=w;
				}
				if(pshape==1)
				{
					if(!(p1.getComponentAt(x+w,y)instanceof JButton||p1.getComponentAt(x+w,y+w)instanceof JButton||p1.getComponentAt(x+w,y+w+w)instanceof JButton))
						x+=w;
				}
				if(pshape==2)
				{
					if(!(p1.getComponentAt(x+w+w,y+w)instanceof JButton||p1.getComponentAt(x,y-w)instanceof JButton))
						x+=w;
				}
				if(pshape==3)
				{
					if(!(p1.getComponentAt(x+w+w,y)instanceof JButton||p1.getComponentAt(x+w,y+w+w)instanceof JButton))
						x+=w;
				}
				if(pshape==4)
				{
					if(!(p1.getComponentAt(x+w+w,y+w)instanceof JButton||p1.getComponentAt(x+w+w,y+w+w)instanceof JButton))
						x+=w;
				}
				if(bshape==1)
				{
					if(!(p1.getComponentAt(x+w,y)instanceof JButton||p1.getComponentAt(x+w,y+w)instanceof JButton||p1.getComponentAt(x,y+w+w)instanceof JButton))
						x+=w;
				}
				if(bshape==2)
				{
					if(!(p1.getComponentAt(x+w+w,y+w)instanceof JButton))
						x+=w;
				}
				if(gshape==1)
				{
					if(!(p1.getComponentAt(x+w,y+w)instanceof JButton||p1.getComponentAt(x+w,y+w+w)instanceof JButton))
						x+=w;
				}
				if(gshape==2)
				{
					if(!(p1.getComponentAt(x+w,y+w+w)instanceof JButton||p1.getComponentAt(x+w+w,y+w)instanceof JButton))
						x+=w;
				}
				if(sshape==1)
				{
					if(!(p1.getComponentAt(x+w,y+w)instanceof JButton||p1.getComponentAt(x+w,y)instanceof JButton))
						x+=w;
				}
				if(oshape==1)
				{
					if(!(p1.getComponentAt(x+w+w,y+w)instanceof JButton||p1.getComponentAt(x+w,y+w+w)instanceof JButton))
						x+=w;
				}
				if(oshape==2)
				{
					if(!(p1.getComponentAt(x+w,y)instanceof JButton||p1.getComponentAt(x+w,y+w)instanceof JButton||p1.getComponentAt(x+w,y+w+w)instanceof JButton))
						x+=w;
				}
				if(oshape==3)
				{
					if(!(p1.getComponentAt(x+w+w,y+w)instanceof JButton))
						x+=w;
				}
				if(oshape==4)
				{
					if(!(p1.getComponentAt(x+w,y+w)instanceof JButton||p1.getComponentAt(x,y+w+w)instanceof JButton))
						x+=w;
				}
				
			}
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN)
			sleep=0;
	}
	public void keyTyped(KeyEvent e){}
	public void keyReleased(KeyEvent e){}
	public void actionPerformed(ActionEvent e)
	{
		try{JButton b=(JButton)e.getSource();
		if(b==bstart)
		{
			start=true;
		}
		if(b==bpause)
		{
			if(start)
			{
				pause=!pause;
				if(!pause)
					b.setText("RESUME");
				else
					b.setText("PAUSE");
			}
		}
		if(b==bexit)
			System.exit(0);
		}catch(Exception e111)
		{
				System.out.println("vishal"+e111);
			jc.requestFocus();
		}
	}
	public void itemStateChanged(ItemEvent e)
	{
		jc.requestFocus();
	}
	public void focusLost(FocusEvent e)
	{}
	public void focusGained(FocusEvent e)
	{
		focus=false;
		jc.requestFocus();
	}
	public static void main(String args[])
	{
		new TetrisGame();
	}
}