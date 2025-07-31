import javax.swing.*;
import java.awt.*;

public class SpiderChartFrame extends JFrame {
    private Player player1;
    private Player player2;
    
    public SpiderChartFrame(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        
        // 프레임 설정
        setTitle("Player Comparison - Simple GUI");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // 텍스트 패널 추가
        add(new TextPanel());
    }
    
    // 텍스트를 출력하는 패널
    class TextPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            
            // 제목 표시
            g2d.setColor(Color.BLACK);
            g2d.setFont(new Font("Arial", Font.BOLD, 20));
            g2d.drawString("Player Comparison", 50, 50);
            
            // 선수 정보 표시
            g2d.setFont(new Font("Arial", Font.PLAIN, 14));
            g2d.drawString(player1.getName() + " vs " + player2.getName(), 50, 80);
            
            // 능력치 비교 표시
            g2d.drawString("Shooting: " + player1.getShooting() + " vs " + player2.getShooting(), 50, 110);
            g2d.drawString("Passing: " + player1.getPassing() + " vs " + player2.getPassing(), 50, 130);
            g2d.drawString("Dribbling: " + player1.getDribbling() + " vs " + player2.getDribbling(), 50, 150);
            g2d.drawString("Pace: " + player1.getPace() + " vs " + player2.getPace(), 50, 170);
            g2d.drawString("Stamina: " + player1.getStamina() + " vs " + player2.getStamina(), 50, 190);
        }
    }
} 