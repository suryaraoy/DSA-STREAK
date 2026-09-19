class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int xi=0;
        int yi=0;

        if(x1 > xCenter) xi=x1;
        else if(x2 < xCenter) xi=x2;
        else xi=xCenter;

        if(y1 > yCenter) yi=y1;
        else if(y2 < yCenter) yi=y2;
        else yi=yCenter;

        int dx=xi-xCenter;
        int dy=yi-yCenter;
        int diameter=(int)Math.sqrt(dx*dx+dy*dy);

        return diameter <= radius ? true : false;
    }
}