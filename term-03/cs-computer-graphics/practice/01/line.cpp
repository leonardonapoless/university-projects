#include <GLUT/glut.h>
#include <OpenGL/gl.h>

void Draw(void) {
    glClear(GL_COLOR_BUFFER_BIT);


    glColor3f(0.2, 0.8, 1.0);

    glFLush();
}

void Initialize(void) { glClearColor(0.0, 0.0, 1.0); }

int main(int argc, char **argv) {
    glutInit(&argc, argv);
    glutInitWindowSize(500, 500);
    glutInitWindowPosition(0, 0);
    glutCreateWindow("Line");
    Initialize();
    glutDisplayFunc(Draw);
    glutMainLoop();
}

