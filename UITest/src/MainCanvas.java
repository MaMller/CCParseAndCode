import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

class MainCanvas extends Canvas
{
   private String _strText = null;

   private String _strFace = "Dialog";
   private String _strStyle = "Plain";
   private String _strSize = "24";

   public MainCanvas(String strText)
   {
      _strText = strText;
   }

   public void notify(String strFace, String strStyle, String strSize)
   {
      _strFace = strFace;
      _strStyle = strStyle;
      _strSize = strSize;

      repaint();
   }

   public void paint(Graphics g)
   {
      // we must manually blank out the background ourselves in order
      // to avoid bugs in some implementations of the AWT...

      g.setColor(Color.white);

      g.fillRect(0, 0, size().width, size().height);

      // determine the parameters of the new font

      int nStyle = Font.PLAIN;

      if (_strStyle.equals("Bold")) nStyle = Font.BOLD;
      if (_strStyle.equals("Italic")) nStyle = Font.ITALIC;

      int nSize = 24;

      try
      {
         nSize = Integer.parseInt(_strSize);
      }
      catch (NumberFormatException e)
      {
         nSize = 24;
      }

      // create and set the new font

      Font f = new Font(_strFace, nStyle, nSize);

      g.setFont(f);

      // get its metrics

      FontMetrics fm1 = g.getFontMetrics();

      int a1 = fm1.getAscent();

      int l1 = fm1.getLeading();

      int d1 = fm1.getDescent();

      int w1 = fm1.stringWidth(_strText);

      int x1 = (size().width - w1) / 2;

      // draw baseline, ascent, and descent

      g.setColor(Color.black);

      g.drawLine(x1 - 10, 100, x1 + 10 + w1, 100);
      g.drawLine(x1 - 10, 101, x1 + 10 + w1, 101);

      g.drawLine(x1 - 10, 100 - a1, x1 + 10 + w1, 100 - a1);

      g.drawLine(x1 - 10, 100 + d1, x1 + 10 + w1, 100 + d1);

      // draw "ascent" and "descent"

      g.setFont(new Font("Dialog", Font.PLAIN, 12));

      FontMetrics fm2 = g.getFontMetrics();

      int w2 = fm2.stringWidth("ascent");

      g.drawString("ascent", x1 + 10 + w1 - w2, 100 - a1 - 2);

      w2 = fm2.stringWidth("descent");

      int a2 = fm2.getAscent();

      g.drawString("descent", x1 + 10 + w1 - w2, 100 + d1 + a2 + 2);

      // draw the width lines

      int x = x1;

      for (int i = 0; i < _strText.length() && x < x1 + 10 + w1 - w2; i++)
      {
         g.drawLine(x, 105, x, 95 - a1);

         x += fm1.charWidth(_strText.charAt(i));
      }
      
      // draw the text

      g.setFont(f);

      g.setColor(Color.blue);

      g.drawString(_strText, x1, 100);
   }
}