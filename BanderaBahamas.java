

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLJPanel;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class BanderaBahamas extends JFrame implements GLEventListener {

    public BanderaBahamas() {
        super("Bandera de las Bahamas - JOGL");

        GLProfile perfil = GLProfile.get(GLProfile.GL2);
        GLCapabilities capacidades = new GLCapabilities(perfil);

        GLJPanel panel = new GLJPanel(capacidades);
        panel.addGLEventListener(this);
        panel.setPreferredSize(new Dimension(800, 400));

        add(panel);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void init(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glClearColor(1f, 1f, 1f, 1f); 
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);


        gl.glColor3f(0.0f, 0.467f, 0.545f);
        gl.glBegin(GL2.GL_QUADS);
            gl.glVertex2f(0f, 0f);
            gl.glVertex2f(2f, 0f);
            gl.glVertex2f(2f, 1f / 3f);
            gl.glVertex2f(0f, 1f / 3f);
        gl.glEnd();

        gl.glColor3f(1.0f, 0.78f, 0.173f);
        gl.glBegin(GL2.GL_QUADS);
            gl.glVertex2f(0f, 1f / 3f);
            gl.glVertex2f(2f, 1f / 3f);
            gl.glVertex2f(2f, 2f / 3f);
            gl.glVertex2f(0f, 2f / 3f);
        gl.glEnd();

       
        gl.glColor3f(0.0f, 0.467f, 0.545f);
        gl.glBegin(GL2.GL_QUADS);
            gl.glVertex2f(0f, 2f / 3f);
            gl.glVertex2f(2f, 2f / 3f);
            gl.glVertex2f(2f, 1f);
            gl.glVertex2f(0f, 1f);
        gl.glEnd();

        gl.glColor3f(0f, 0f, 0f);
        gl.glBegin(GL2.GL_TRIANGLES);
            gl.glVertex2f(0f, 0f);
            gl.glVertex2f(0f, 1f);
            gl.glVertex2f(0.866f, 0.5f);
        gl.glEnd();

        gl.glFlush();
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int ancho, int alto) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glViewport(0, 0, ancho, alto);

        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glOrtho(0, 2, 0, 1, -1, 1);

        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BanderaBahamas().setVisible(true));
    }
}