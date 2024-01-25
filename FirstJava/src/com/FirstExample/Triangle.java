package com.FirstExample;

import java.awt.Color;

// Trinagles simple polygons
// A surface can not be formed with less than three vertices
// Triangles must be flat


public class Triangle {
    Vertex v1;
    Vertex v2;
    Vertex v3;
    Color color;
    Triangle(Vertex v1, Vertex v2, Vertex v3, Color color) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
        this.color = color;
    }
}