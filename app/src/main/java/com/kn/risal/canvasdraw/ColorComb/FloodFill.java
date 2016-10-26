package com.kn.risal.canvasdraw.ColorComb;

import android.graphics.Bitmap;
import android.graphics.Point;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill
{
    private Bitmap _bmp;
    private int _oldColor;
    private int _newColor;
    private int _bmpWidth;
    private int _bmpHeight;

    public FloodFill(Bitmap bmp, int oldColor, int newColor)
    {
        _bmp = bmp;
        _oldColor = oldColor;
        _newColor = newColor;
        _bmpWidth = bmp.getWidth();
        _bmpHeight = bmp.getHeight();
    }

    public void fill(int x, int y)
    {
        // TODO : remove before release.
        // Debug.startMethodTracing("FloodFill");

        // 1. Set Q to the empty queue.
        Queue<Point> queue = new LinkedList<Point>();

        // 2. If the color of node is not equal to target-color, return.
        if (_bmp.getPixel(x, y) == _oldColor)
        {
            // 3. Add node to Q.
            queue.add(new Point(x, y));

            // 4. For each element n of Q.
            while (!queue.isEmpty())
            {
                // 5. If the color of n is equal to target-color.
                Point n = queue.poll();
                if (_bmp.getPixel(n.x, n.y) == _oldColor)
                {
                    // 6. Set w and e equal to n.
                    int wx = n.x;
                    int ex = n.x + 1;

                    // 7. Move w to the west until the color of the node to the
                    // west of w no longer matches target-color.
                    while ((_bmp.getPixel(wx, n.y) == _oldColor) && wx >= 0)
                    {
                        wx--;
                    }

                    // 8. Move e to the east until the color of the node to the
                    // east of e no longer matches target-color.
                    while ((_bmp.getPixel(ex, n.y) == _oldColor) && ex <= _bmpWidth - 1)
                    {
                        ex++;
                    }

                    // 9. Set the color of nodes between w and e to
                    // replacement-color.
                    for (int ix = wx + 1; ix < ex; ix++)
                    {
                        _bmp.setPixel(ix, n.y, _newColor);

                        // 10. For each node n between w and e.
                        // 11. If the color of the node to the north of n is
                        // target-color, add that node to Q.
                        if (n.y - 1 >= 0 && _bmp.getPixel(ix, n.y - 1) == _oldColor)
                        {
                            queue.add(new Point(ix, n.y - 1));
                        }

                        // 12. If the color of the node to the south of n is
                        // target-color, add that node to Q.
                        if (n.y + 1 < _bmpHeight && _bmp.getPixel(ix, n.y + 1) == _oldColor)
                        {
                            queue.add(new Point(ix, n.y + 1));
                        }
                    }
                }
            }
        }

        // TODO : remove before release.
        // Debug.startMethodTracing();
    }
}
