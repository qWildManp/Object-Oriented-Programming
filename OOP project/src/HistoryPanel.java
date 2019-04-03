/*
 * Author : Harry He
 * ID : 1730026028
 * Project*/
import javax.swing.*;
import java.util.*;
import java.awt.*;
class HistoryPanel extends JPanel{
	private ArrayList<Integer> history;
	public HistoryPanel(ElectricityCompany m) {//construction of history panel
		this.history = m.getHistory();
	}
	public int historyMax(ArrayList<Integer> h) {//get the max value of history
		int result = 0;
		for(int i = 0;i < h.size();i++) {
			if(h.get(i) > result) {
				result = h.get(i);
			}
		}
		return result;
	}
	public int historyMin(ArrayList<Integer> h) {//get the minimum value of history
		int result = 0;
		for(int i = 0;i < h.size();i++) {
			if(h.get(i) < result) {
				result = h.get(i);
			}
		}
		return result;
	}
	public int historyRange(ArrayList<Integer> h) {//get the range between max value and minimum value 
		int max = this.historyMax(h);
		int min = this.historyMin(h);
		int range = max - min;
		if(range < 200) {//if the range is less than 200
			return 200;
		}
		else {
			return range;
		}
	}
	@Override
	protected void paintComponent(Graphics g) {//draw the graphic of history
		super.paintComponent(g);
		int min = historyMin(history);
		int range = historyRange(history);
		int maxX = this.getWidth() - 1;
		int maxY = this.getHeight() - 1;
		int zero = maxY + min * maxY / range;
		g.setColor(Color.BLUE);
		g.drawLine(0, zero, maxX, zero);
		g.setColor(Color.RED);
		int x = 0;
		int y  = 0;
		for(int i = 0;i < this.history.size(); i ++) {//draw a line between history points
			x = i * 10;
			int v = this.history.get(i);
			y = zero - v * maxY / range;
			if(i == 0) {
				g.drawRect(x, y, 1, 1);
			}
			else {
				g.drawLine(x, y,((i-1)*10), (zero - this.history.get(i-1) * maxY/range));
			}
		}
	}
}
