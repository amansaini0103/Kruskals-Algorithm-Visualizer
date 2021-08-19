package com.example.kruskalsalgorithmvisualizer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import java.util.*;
import java.lang.*;
import java.io.*;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void msg1(View view)
    {
        Toast.makeText(this,"STEP 1: Sort all the edges in increasing order of edge weights.",Toast.LENGTH_LONG).show();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                step1(view);
            }
        }, 5000);
    }

    public void msg2(View view)
    {
        Toast.makeText(this,"STEP 2: Take the edge with lowest weight and add it it spanning tree. If that edge create a cycle reject that edge. Do this until all vertices are reached.",Toast.LENGTH_LONG).show();
        Toast.makeText(this,"STEP 2: Take the edge with lowest weight and add it it spanning tree. If that edge create a cycle reject that edge. Do this until all vertices are reached.",Toast.LENGTH_LONG).show();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                step2(view);
            }
        }, 10000);
    }
    public void step1(View view)
    {
        ImageView cd=(ImageView)findViewById(R.id.cd);
        ImageView af=(ImageView)findViewById(R.id.af);
        ImageView gb=(ImageView)findViewById(R.id.gb);
        ImageView bc=(ImageView)findViewById(R.id.bc);
        ImageView dg=(ImageView)findViewById(R.id.ad);
        ImageView ed=(ImageView)findViewById(R.id.ed);
        ImageView ge=(ImageView)findViewById(R.id.ae);
        ImageView ef=(ImageView)findViewById(R.id.ef);
        ImageView ab=(ImageView)findViewById(R.id.ab);

        TextView valueCD=(TextView)findViewById(R.id.valueCD);
        TextView valueAF=(TextView)findViewById(R.id.valueAF);
        TextView valueBG=(TextView)findViewById(R.id.valueBG);
        TextView valueBC=(TextView)findViewById(R.id.valueBC);
        TextView valueDG=(TextView)findViewById(R.id.valueDG);
        TextView valueDE=(TextView)findViewById(R.id.valueDE);
        TextView valueGE=(TextView)findViewById(R.id.valueGE);
        TextView valueEF=(TextView)findViewById(R.id.valueEF);
        TextView valueAB=(TextView)findViewById(R.id.valueAB);

        ImageView cddown=(ImageView)findViewById(R.id.cddown);
        ImageView afdown=(ImageView)findViewById(R.id.afdown);
        ImageView bgdown=(ImageView)findViewById(R.id.bgdown);
        ImageView bcdown=(ImageView)findViewById(R.id.bcdown);
        ImageView dgdown=(ImageView)findViewById(R.id.dgdown);
        ImageView dedown=(ImageView)findViewById(R.id.dedown);
        ImageView gedown=(ImageView)findViewById(R.id.gedown);
        ImageView efdown=(ImageView)findViewById(R.id.efdown);
        ImageView abdown=(ImageView)findViewById(R.id.abdown);

        cd.animate().alpha(0).setDuration(3000);
        valueCD.animate().alpha(0).setDuration(3000);
        cddown.animate().alpha(1).setDuration(3000).setStartDelay(4000);

        af.animate().alpha(0).setDuration(3000).setStartDelay(7000);
        valueAF.animate().alpha(0).setDuration(3000).setStartDelay(7000);
        afdown.animate().alpha(1).setDuration(3000).setStartDelay(10000);

        gb.animate().alpha(0).setDuration(3000).setStartDelay(13000);
        valueBG.animate().alpha(0).setDuration(3000).setStartDelay(13000);
        bgdown.animate().alpha(1).setDuration(3000).setStartDelay(16000);

        bc.animate().alpha(0).setDuration(3000).setStartDelay(19000);
        valueBC.animate().alpha(0).setDuration(3000).setStartDelay(19000);
        bcdown.animate().alpha(1).setDuration(3000).setStartDelay(22000);

        dg.animate().alpha(0).setDuration(3000).setStartDelay(25000);
        valueDG.animate().alpha(0).setDuration(3000).setStartDelay(25000);
        dgdown.animate().alpha(1).setDuration(3000).setStartDelay(28000);

        ed.animate().alpha(0).setDuration(3000).setStartDelay(31000);
        valueDE.animate().alpha(0).setDuration(3000).setStartDelay(31000);
        dedown.animate().alpha(1).setDuration(3000).setStartDelay(34000);

        ge.animate().alpha(0).setDuration(3000).setStartDelay(37000);
        valueGE.animate().alpha(0).setDuration(3000).setStartDelay(37000);
        gedown.animate().alpha(1).setDuration(3000).setStartDelay(40000);

        ef.animate().alpha(0).setDuration(3000).setStartDelay(43000);
        valueEF.animate().alpha(0).setDuration(3000).setStartDelay(43000);
        efdown.animate().alpha(1).setDuration(3000).setStartDelay(46000);

        ab.animate().alpha(0).setDuration(3000).setStartDelay(49000);
        valueAB.animate().alpha(0).setDuration(3000).setStartDelay(49000);
        abdown.animate().alpha(1).setDuration(3000).setStartDelay(52000);

    }
    public void step2(View view)
    {
        ImageView cd=(ImageView)findViewById(R.id.cd);
        ImageView af=(ImageView)findViewById(R.id.af);
        ImageView gb=(ImageView)findViewById(R.id.gb);
        ImageView bc=(ImageView)findViewById(R.id.bc);
        ImageView dg=(ImageView)findViewById(R.id.ad);
        ImageView ed=(ImageView)findViewById(R.id.ed);
        ImageView ge=(ImageView)findViewById(R.id.ae);
        ImageView ef=(ImageView)findViewById(R.id.ef);
        ImageView ab=(ImageView)findViewById(R.id.ab);
        ImageView cross=(ImageView)findViewById(R.id.cross);
        ImageView cross1=(ImageView)findViewById(R.id.cross1);

        TextView valueCD=(TextView)findViewById(R.id.valueCD);
        TextView valueAF=(TextView)findViewById(R.id.valueAF);
        TextView valueBG=(TextView)findViewById(R.id.valueBG);
        TextView valueBC=(TextView)findViewById(R.id.valueBC);
        TextView valueDG=(TextView)findViewById(R.id.valueDG);
        TextView valueDE=(TextView)findViewById(R.id.valueDE);
        TextView valueGE=(TextView)findViewById(R.id.valueGE);
        TextView valueEF=(TextView)findViewById(R.id.valueEF);
        TextView valueAB=(TextView)findViewById(R.id.valueAB);
        TextView rejectedwale=(TextView)findViewById(R.id.rejectedwale);
        TextView samplegraph=(TextView)findViewById(R.id.samplegraph);

        ImageView cddown=(ImageView)findViewById(R.id.cddown);
        ImageView afdown=(ImageView)findViewById(R.id.afdown);
        ImageView bgdown=(ImageView)findViewById(R.id.bgdown);
        ImageView bcdown=(ImageView)findViewById(R.id.bcdown);
        ImageView dgdown=(ImageView)findViewById(R.id.dgdown);
        ImageView dedown=(ImageView)findViewById(R.id.dedown);
        ImageView gedown=(ImageView)findViewById(R.id.gedown);
        ImageView efdown=(ImageView)findViewById(R.id.efdown);
        ImageView abdown=(ImageView)findViewById(R.id.abdown);

        cddown.animate().alpha(0).setDuration(2000).setStartDelay(2000);
        valueCD.animate().alpha(1).setDuration(2000);
        cd.animate().alpha(1).setDuration(2000);

        afdown.animate().alpha(0).setDuration(2000).setStartDelay(6000);
        valueAF.animate().alpha(1).setDuration(2000).setStartDelay(4000);
        af.animate().alpha(1).setDuration(2000).setStartDelay(4000);

        bgdown.animate().alpha(0).setDuration(2000).setStartDelay(10000);
        valueBG.animate().alpha(1).setDuration(2000).setStartDelay(8000);
        gb.animate().alpha(1).setDuration(2000).setStartDelay(8000);

        bcdown.animate().alpha(0).setDuration(2000).setStartDelay(13000);
        valueBC.animate().alpha(1).setDuration(2000).setStartDelay(10000);
        bc.animate().alpha(1).setDuration(2000).setStartDelay(10000);

        dgdown.animate().alpha(0).setDuration(2000).setStartDelay(16000);
        valueDG.animate().alpha(1).setDuration(2000).setStartDelay(13000);
        dg.animate().alpha(1).setDuration(2000).setStartDelay(13000);

        cross.animate().alpha(1).setStartDelay(17000);

        dedown.animate().alpha(0).setDuration(2000).setStartDelay(22000);
        valueDE.animate().alpha(1).setDuration(2000).setStartDelay(20000);
        ed.animate().alpha(1).setDuration(2000).setStartDelay(20000);

        gedown.animate().alpha(0).setDuration(2000).setStartDelay(26000);
        valueGE.animate().alpha(1).setDuration(2000).setStartDelay(22000);
        ge.animate().alpha(1).setDuration(2000).setStartDelay(22000);

        cross1.animate().alpha(1).setStartDelay(26000);

        efdown.animate().alpha(0).setDuration(2000).setStartDelay(32000);
        valueEF.animate().alpha(1).setDuration(2000).setStartDelay(30000);
        ef.animate().alpha(1).setDuration(2000).setStartDelay(30000);

        rejectedwale.animate().alpha(1).setStartDelay(35000);
        samplegraph.animate().alpha(0).setStartDelay(35000);

    }
    public void compare(View view)
    {
        ImageView before=(ImageView)findViewById(R.id.before);
        ImageView after=(ImageView)findViewById(R.id.after);
        ImageView cost=(ImageView)findViewById(R.id.cost);

        before.animate().alpha(1);
        after.animate().alpha(1);
        cost.animate().alpha(1);
    }

    class Graph {
        // A class to represent a graph edge
        class Edge implements Comparable<Edge>
        {
            int src, dest, weight;

            // Comparator function used for
            // sorting edgesbased on their weight
            public int compareTo(Edge compareEdge)
            {
                return this.weight - compareEdge.weight;
            }
        };

        // A class to represent a subset for
        // union-find
        class subset
        {
            int parent, rank;
        };

        int V, E; // V-> no. of vertices & E->no.of edges
        Edge edge[]; // collection of all edges

        // Creates a graph with V vertices and E edges
        Graph(int v, int e)
        {
            V = v;
            E = e;
            edge = new Edge[E];
            for (int i = 0; i < e; ++i)
                edge[i] = new Edge();
        }

        // A utility function to find set of an
        // element i (uses path compression technique)
        int find(subset subsets[], int i)
        {
            // find root and make root as parent of i
            // (path compression)
            if (subsets[i].parent != i)
                subsets[i].parent
                        = find(subsets, subsets[i].parent);

            return subsets[i].parent;
        }

        // A function that does union of two sets
        // of x and y (uses union by rank)
        void Union(subset subsets[], int x, int y)
        {
            int xroot = find(subsets, x);
            int yroot = find(subsets, y);

            // Attach smaller rank tree under root
            // of high rank tree (Union by Rank)
            if (subsets[xroot].rank
                    < subsets[yroot].rank)
                subsets[xroot].parent = yroot;
            else if (subsets[xroot].rank
                    > subsets[yroot].rank)
                subsets[yroot].parent = xroot;

                // If ranks are same, then make one as
                // root and increment its rank by one
            else {
                subsets[yroot].parent = xroot;
                subsets[xroot].rank++;
            }
        }

        // The main function to construct MST using Kruskal's
        // algorithm
        void KruskalMST()
        {
            Edge result[] = new Edge[V];

            int e = 0;
            int i = 0;
            for (i = 0; i < V; ++i)
                result[i] = new Edge();
            Arrays.sort(edge);
            subset subsets[] = new subset[V];
            for (i = 0; i < V; ++i)
                subsets[i] = new subset();
            for (int v = 0; v < V; ++v)
            {
                subsets[v].parent = v;
                subsets[v].rank = 0;
            }
            i = 0;
            while (e < V-1)
            {
                Edge next_edge = edge[i++];
                int x = find(subsets, next_edge.src);
                int y = find(subsets, next_edge.dest);
                if (x != y) {
                    result[e++] = next_edge;
                    Union(subsets, x, y);
                }
            }
            System.out.println("Following are the edges in "
                    + "the constructed MST");
            int minimumCost = 0;
            for (i = 0; i < e; ++i)
            {
                System.out.println(result[i].src + " -- "
                        + result[i].dest
                        + " == " + result[i].weight);
                minimumCost += result[i].weight;
            }
            System.out.println("Minimum Cost Spanning Tree "
                    + minimumCost);
        }

        public void main(String[] args)
        {
            int V = 7; // Number of vertices in graph
            int E = 9; // Number of edges in graph
            Graph graph = new Graph(V, E);

            // add edge A-B
            graph.edge[0].src = 0;
            graph.edge[0].dest = 1;
            graph.edge[0].weight = 28;

            // add edge A-F
            graph.edge[1].src = 0;
            graph.edge[1].dest = 5;
            graph.edge[1].weight = 14;

            // add edge B-C
            graph.edge[2].src = 1;
            graph.edge[2].dest = 2;
            graph.edge[2].weight = 16;

            // add edge B-G
            graph.edge[3].src = 1;
            graph.edge[3].dest = 6;
            graph.edge[3].weight = 14;

            // add edge C-D
            graph.edge[4].src = 2;
            graph.edge[4].dest = 3;
            graph.edge[4].weight = 12;

            // add edge D-G
            graph.edge[5].src = 3;
            graph.edge[5].dest = 6;
            graph.edge[5].weight = 18;

            // add edge D-E
            graph.edge[6].src = 3;
            graph.edge[6].dest = 4;
            graph.edge[6].weight = 22;

            // add edge E-G
            graph.edge[7].src = 4;
            graph.edge[7].dest = 6;
            graph.edge[7].weight = 24;

            // add edge E-F
            graph.edge[8].src = 4;
            graph.edge[8].dest = 5;
            graph.edge[8].weight = 25;

            // Function call
            graph.KruskalMST();
        }
    }
}