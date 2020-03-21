public class Body{
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    static final double G=6.67e-11;

    public Body(double xP, double yP, double xV,
                double yV, double m, String img){
        xxPos=xP;
        yyPos=yP;
        xxVel=xV;
        yyVel=yV;
        mass=m;
        imgFileName=img;
    }
    public Body(Body b){
        xxPos=b.xxPos;
        yyPos=b.yyPos;
        xxVel=b.xxVel;
        yyVel=b.yyVel;
        mass=b.mass;
        imgFileName=b.imgFileName;
    }

    public double calcDistance(Body b){
        return (double)Math.sqrt((this.xxPos-b.xxPos)*(this.xxPos-b.xxPos)+(this.yyPos-b.yyPos)*(this.yyPos-b.yyPos));
    }
    public double calcForceExertedBy(Body b){
        return (double)6.67*(this.mass*b.mass/1000000)/(this.calcDistance(b)*this.calcDistance(b)*100000);
    }
    public double calcForceExertedByX(Body b) {
        if((-this.xxPos+b.xxPos)==0){
            return 0;
        }
        double dis=(-this.xxPos+b.xxPos);
        if(dis<0){
            return (double)-G*(this.mass*b.mass)/(dis*dis);
        }
        return (double)G*(this.mass*b.mass)/(dis*dis);
    }
    public double calcForceExertedByY(Body b) {
        if((-this.yyPos+b.yyPos)==0){
            return 0;
        }
        double dis=(-this.yyPos+b.yyPos);
        if(dis<0){
            return (double)-G*(this.mass*b.mass)/(dis*dis);
        }
        return (double)G*(this.mass*b.mass)/(dis*dis);
    }

    public double calcNetForceExertedByX(Body []b){
        double sum=0;
        for(Body body:b){
            sum =sum+this.calcForceExertedByX(body);
        }
        return sum;
    }
    public double calcNetForceExertedByY(Body []b){
        double sum=0;
        for(Body body:b){
            sum =sum+this.calcForceExertedByY(body);
        }
        return sum;
    }

    public void update(double t,double fx,double fy){
        this.yyVel=this.yyVel+(fy/this.mass)*t;
        this.xxVel=this.xxVel+(fy/this.mass)*t;
        this.yyPos=this.yyPos+this.yyVel*t;
        this.xxPos=this.xxPos+this.xxVel*t;
        return;
    }

    public void draw(){
        StdDraw.picture(this.xxPos,this.yyPos, this.imgFileName);
        return;
    }
}