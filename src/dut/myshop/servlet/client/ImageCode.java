package dut.myshop.servlet.client;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ImageCode
 */
@WebServlet("/imageCode")
public class ImageCode extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ImageCode() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int charNum = 4;
		int width = 80;
		int height = 30;
		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics graphics = bufferedImage.getGraphics();
		graphics.setColor(Color.YELLOW);
		graphics.fillRect(0, 0, width, height);
		graphics.setColor(Color.GRAY);
		graphics.drawRect(0, 0, width - 1, height - 1);
		graphics.setColor(Color.RED);
		graphics.setFont(new Font("ËÎÌו", Font.BOLD, 22));
		String s = "ABCDEFGHJKLMNPQRSTUVWXYZ23456789";
		Random random = new Random();
		String msg = "";
		int x = 5;
		for (int i = 0; i < charNum; i++) {
			int index = random.nextInt(s.length());
			String content = String.valueOf(s.charAt(index));
			msg += content;
			graphics.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
			graphics.drawString(content, x, 20);
			x += 20;
		}
		graphics.setColor(Color.GRAY);
		for (int i = 0; i < 5; i++) {
			int x1 = random.nextInt(width);
			int x2 = random.nextInt(width);
			int y1 = random.nextInt(height);
			int y2 = random.nextInt(height);
			graphics.drawLine(x1, y1, x2, y2);
		}
		graphics.dispose();
		ImageIO.write(bufferedImage, "jpg", response.getOutputStream());
		HttpSession session=request.getSession();
		session.removeAttribute("imageCode");
		session.setAttribute("imageCode", msg);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
