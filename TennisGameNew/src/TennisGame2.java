
public class TennisGame2 implements TennisGame
{
    public int P1point = 0;
    public int P2point = 0;
    
    public String P1res = "";
    public String P2res = "";
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore()
    {
        String score = "";
        if(isTie())
    		literalScore = getLiteral(P1_Points) + "-" + "-All";
        
        score = Deuce(score);
        
        score = normal(score);
        score = normal1(score);
        
        score = normal2(score);
        score = normal3(score);
        score = advantage(score);
        
        score = win(score);
        return score;
    }
    
    private boolean isTie() 
    {
    	return P1_Points == P2_Points && P1_Points < 4;
    }
    
    private String tie() 
	{ String result= "";
		if (isTie())
           result= getLiteral(P1_Points)+"-All";
		return result;
	}
    
    private String getLiteral(int p1point2) 
	{
		String result = "";
		if (p1point2==0)
			result = "Love";
		if (p1point2==1)
			result = "Fifteen";
		if (p1point2==2)
			result = "Thirty";
		if (p1point2==3)
			result = "Forty";
		return result;
	}
    
    private String win(String score) 
	{
		if (P1point>=4 && P2point>=0 && (P1point-P2point)>=2)
        {
            score = "Win for player1";
        }
        if (P2point>=4 && P1point>=0 && (P2point-P1point)>=2)
        {
            score = "Win for player2";
        }
		return score;
	}
    
    private String advantage(String score) 
	{
		if (P1point > P2point && P2point >= 3)
        {
            score = "Advantage player1";
        }
        
        if (P2point > P1point && P1point >= 3)
        {
            score = "Advantage player2";
        }
		return score;
	}
   
    private String Deuce(String score) 
	{
		if (P1point==P2point && P1point>=3)
            score = "Deuce";
		return score;
	}
    
	private String normal(String score) 
	{
		if (P2_Points != P1_Points)
        {
            score = getLiteral(P1_Points) + "-" + getLiteral(P2_Points);
        }
		return score;
	}
    
    public void SetP1Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P1Score();
        }
            
    }
    
    public void SetP2Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P2Score();
        }
            
    }
    
    public void P1Score(){
        P1point++;
    }
    
    public void P2Score(){
        P2point++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}