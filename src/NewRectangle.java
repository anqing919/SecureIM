/*第2题:
public class NewRectangle {
    double width,height;
    public NewRectangle() {                     //默认构造方法
        width=0.0;
        height=0.0;
        }
    public NewRectangle(double w,double h) {    //带2个参数的构造方法
        width=w;
        height=h;
        }
    public double getArea() {return width*height;}
    public double getPreimeter() {return 2*(width+height);}
}*/


public class NewRectangle {
    double width,height;
    Point lowerLeft=new Point();
    /*3.(3)中两种构造方法*/
    public NewRectangle(double w,double h) {
        width=w;
        height=h;
        lowerLeft.x=0.0;
        lowerLeft.y=0.0;
    }
    public NewRectangle(double w,double h,double px,double py) {
        width=w;
        height=h;
        lowerLeft.x=px;
        lowerLeft.y=py;
    }
    public double getArea() {
        return width*height;
    }
    public double getPreimeter() {
        return 2*(width+height);
    }
    boolean bPointIn(Point p){
        if((lowerLeft.x<=p.x&&p.x<=lowerLeft.x+width)&&
                (lowerLeft.y<=p.y&&p.y<=lowerLeft.y+height)){
            return true;
        }
        return false;
    }
    /*能判断此矩阵是否包含了另一个矩阵*/
    boolean hRectange(NewRectangle r1){
        if((this.lowerLeft.x<=r1.lowerLeft.x&&this.lowerLeft.y<=r1.lowerLeft.y)&&
                (this.lowerLeft.x+this.width>=r1.lowerLeft.x+r1.width&&this.lowerLeft.y+this.height>=r1.lowerLeft.y+r1.height)){
            return true;
        }
        return false;
    }
    /*能判断此矩阵是否于另一矩阵有重叠部分(仅有公共线也被认为有重叠部分)*/
    boolean wRectang(NewRectangle r2){
        if(r2.lowerLeft.x+r2.width<this.lowerLeft.x||           //当测试矩形在当前矩形的左方
                r2.lowerLeft.x>this.lowerLeft.x+this.width||            //右方
                r2.lowerLeft.y+r2.height<this.lowerLeft.y||             //下方
                r2.lowerLeft.y>this.lowerLeft.y+this.height){           //上方
            return false;                                       //这时说明测试矩形不在当前矩形的内部
        }
        return true;
    }

}

class Point{
    double x,y;
    public Point(){                                 //默认构造方法
        x=0.0;
        y=0.0;
    }
    public Point(double init_x,double init_y){      //带两个参数的构造方法
        x=init_x;
        y=init_y;
    }
    public double distance(Point p){
        return Math.sqrt(Math.pow((x-p.x),2)+Math.pow((y-p.y),2));
    }
}
