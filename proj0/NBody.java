public class NBody{
    public static double readRadius(String s){
        In in = new In(s);
        int N = in.readInt();
        double radius = in.readDouble();
        return radius;
    }

    public static Body[] readBodies(String s){
        In in = new In(s);
        int N = in.readInt();
        double radius = in.readDouble();
        Body[] bodies=new Body[5];
        int i=0;
        while(N>0){
        double xP=in.readDouble();
        double yP=Double.parseDouble(in.readString());
        double xV=Double.parseDouble(in.readString());
        double yV=Double.parseDouble(in.readString());
        double m=Double.parseDouble(in.readString());
        String img=in.readString();
        Body plante=new Body(xP,yP,xV,
        yV,m,img);
        bodies[i]=plante;
        i++;
        N--;
        }
        return bodies;
    }

    public static void main(String[] args) {
        double T=Double.parseDouble(args[0]);
        double dt=Double.parseDouble(args[1]);
        String filename=args[2];
        Body[] bodies=readBodies(filename);
        double radius=readRadius(filename);
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(-radius, radius);
        StdDraw.setYscale(-radius, radius);
        StdDraw.picture(-radius/100, radius/100, "images/starfield.jpg");
        for(int i=0;i<bodies.length;i++){

            bodies[i].draw();
        }
        StdDraw.pause(100);
        StdDraw.show();

        for (double time =0;T>time;time+=dt){
            double[] xForce=new double[5];
            double[] yForce=new double[5];
            int i=0;
            for(Body body:bodies){
                xForce[i]=body.calcNetForceExertedByX(bodies);
                yForce[i]=body.calcNetForceExertedByY(bodies);
                i++;
            }
            StdDraw.pause(100);
          //  System.out.println(xForce[1]);
            //System.out.println(yForce[1]);

//            i=0;
//            for(Body body:bodies){
//            body.update(time,xForce[i],yForce[i]);
//           // System.out.println("xpos" +body.xxPos);
//            i++;
//            }
            StdDraw.pause(100);
            StdDraw.setXscale(-radius, radius);
            StdDraw.setYscale(-radius, radius);
            StdDraw.picture(-radius/100, radius/100, "images/starfield.jpg");
            i=0;
            for(i=0;i<bodies.length;i++){
                bodies[i].update(time,xForce[i],yForce[i]);
                bodies[i].draw();
                StdDraw.pause(100);
                StdDraw.picture(-radius/100, radius/100, "images/starfield.jpg");
            }
            StdDraw.pause(100);
            System.out.println(time);
        }
    }
}