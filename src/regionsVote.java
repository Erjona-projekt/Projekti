/*(b) The election becomes a national election in 3 regions. Make the application
        display the total vote counts for each region as well as the total vote counts
        for each candidate.*/

import javax.swing.*; // JOptionPane
public class regionsVote {
    public static void main(String[] args)
    {   int num_candidates = 4;                  // how many candidates
        int num_regions = 3;                     // how many regions
        int[][] election = new int[num_regions][num_candidates]; // holds the votes
        // collect the votes until a  -1  is read:
        boolean processing = true;
        while ( processing )
        // all legal votes read so far have been tallied in  votes
        { int r = Integer.parseInt(JOptionPane.showInputDialog("Type your region (0,1,2): "));
            if ( r == -1 )
            { processing = false; }
            else if ( r < 0  ||  r >= num_regions )
            { System.out.println("VoteCount error: region " + r); }
            else { int v = Integer.parseInt(JOptionPane.showInputDialog("Vote for (0,1,2,3): "));
                if ( v >= 0  &&  v < num_candidates )
                { election[r][v] = election[r][v] + 1; }
                else { System.out.println("VoteCount error: vote " + v); }

                /*printing the total votes cast in each region of the election:*/

                for ( int i = 0; i != num_regions; i = i + 1 )
                { int total = 0;
                    for ( int j = 0; j != num_candidates; j = j + 1 )
                    { total = total + election[i][j]; }
                    System.out.println(total + " votes were cast in Region " + i);
                }

        /*To print each candidate's grand total of votes, we write a nested for-loop*/
                for ( int j = 0; j != num_candidates; j = j + 1 )
                { int votes = 0;
                    for ( int i = 0; i != num_regions; i = i + 1 )
                    { votes = votes + election[i][j]; }
                    System.out.println("Candidate " + j + " has " + votes + " votes");

                }
            }
        }
    }
}



