package logic.storage;

import logic.transform.LineDrawable;

import java.util.ArrayList;

public class Storage {

    public ArrayList<Point> points = new ArrayList<>();
    public ArrayList<Line> lines = new ArrayList<>();
    private LineDrawable drawable;

    public Storage(LineDrawable drawable){
        this.drawable = drawable;
    }

    public void draw(){
        drawable.draw(lines.toArray(new Line[lines.size()]));
    }

}
