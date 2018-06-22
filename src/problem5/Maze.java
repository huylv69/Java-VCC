package problem5;

import java.awt.*;
import java.util.Arrays;
import javax.swing.*;

public class Maze {
    public static void main(String[] args) {
        //
        JFrame frame = new JFrame();
        frame.setSize(650, 470);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MazePanel mp = new MazePanel();
        frame.add(mp);
        frame.setVisible(true);
    }

    public static class MazePanel extends JPanel {
        private static final long serialVersionUID = -566807999447681130L;
        private int[][] maze = { // khởi tạo ma trận mảng 2 chiều
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1},
                {1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1},
                {1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1},
                {0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 2, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1},
                {1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1},
                {1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1},
                {1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
        private int sizeh, sizew, start, end;

        public MazePanel() {
            // Kích thước ma trận
            sizeh = 21;
            sizew = 31;
            start = 10;
            end = 0;
            solve();
            repaint(); // vẽ ma trận và lời giải
        }

        /**
         * Implement một phương pháp tìm đường nào đó.
         * <p>
         * Yêu cầu : Vẽ đường đi từ điểm bắt đầu đến điểm kết thúc. Không hiện
         * các phần thừa - là các phần đường cụt hoặc đường đi bị sai. Chỉ vẽ
         * tuyến đường chính đi từ điểm đầu (màu vàng) đến màu đỏ.
         * <p>
         * Đường đi từ điểm đầu đến điểm cuối được tô màu xanh dương, để tô màu
         * xanh dương hãy set giá trị của điểm trên ma trận sang một số > 2
         */
        public void solve() {
            // Hàm này chứa phương pháp tìm đường từ điểm start đến vị trí màu đỏ trên ma trận
            // Tìm vị trí bắt đầu
            int locStartX = 0;
            int locStartY = 0;
            for (int j = 0; j < sizew; j++)
                for (int i = 0; i < sizeh; i++) {
                    if (maze[i][j] == 2) {
                        locStartX = i;
                        locStartY = j;
                        break;
                    }
                }
            if (dfs(locStartX, locStartY))
            {
                maze[locStartX][locStartY] = 2;
                System.out.println("Maze solved!");
            }
            else
                System.out.println("No solution.");
        }

        public boolean dfs(int row, int column) {
            boolean done = false;
            if (valid(row, column)) {
                maze[row][column] = 3;  // Đánh dấu ô đã đi
                if (row == start && column == end)
                    done = true;  // Kiểm tra xem ma trận đã được giải
                else {
                    done = dfs(row + 1, column);  // Đi xuống
                    if (!done)
                        done = dfs(row, column + 1);  // Sang phải
                    if (!done)
                        done = dfs(row - 1, column);  // Lên trên
                    if (!done)
                        done = dfs(row, column - 1);  // Sang trái
                }
                if (done)  // Đường đi đúng
                    maze[row][column] = 7;
            }
            return done;

        }

        // Kiểm tra một ô có thể đi được không
        private boolean valid(int row, int column) {
            boolean result = false;
            // Kiểm tra ô nằm trong ma trận
            if (row >= 0 && row < maze.length &&
                    column >= 0 && column < maze[0].length)
                //  Kiểm tra nếu ô đi được và chưa từng đi qua
                if (maze[row][column] == 0 || maze[row][column] == 2)
                    result = true;
            return result;
        }

        public void paintComponent(Graphics g) // vẽ ma trận + lời giải
        {
            super.paintComponent(g);
            for (int j = 0; j < sizew; j++)
                for (int i = 0; i < sizeh; i++) {
                    if (i == start && j == end)
                        g.setColor(Color.yellow);
                    else if (maze[i][j] == 0)
                        g.setColor(Color.white);
                    else if (maze[i][j] == 1)
                        g.setColor(Color.black);
                    else if (maze[i][j] == 2)
                        g.setColor(Color.red);
                    else if (maze[i][j] == 3)
                        g.setColor(Color.white);
                    else
                        g.setColor(Color.blue); // blue là màu của lời giải
                    g.fillRect(j * 20, i * 20, 20, 20);
                }
        }
    }
}
