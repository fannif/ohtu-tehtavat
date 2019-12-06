
package statistics;

import java.util.ArrayList;
import statistics.matcher.All;
import statistics.matcher.And;
import statistics.matcher.Not;
import statistics.matcher.HasAtLeast;
import statistics.matcher.HasFewerThan;
import statistics.matcher.Matcher;
import statistics.matcher.Or;
import statistics.matcher.PlaysIn;

public class QueryBuilder {
    
    Matcher matcher;
    
    public QueryBuilder() {
        matcher = new All();
    }
    
    public Matcher build() {
        return startOver();
    }
    
    public Matcher startOver() {
        Matcher oldMatcher = matcher;
        matcher = new All();
        return oldMatcher;
    }
    
    public QueryBuilder playsIn(String team) {
        this.matcher = new And(matcher, new PlaysIn(team));
        return this;
    }
    
    public QueryBuilder hasAtLeast(int points, String field) {
        this.matcher = new And(matcher, new HasAtLeast(points, field));
        return this;
    }
    
    public QueryBuilder hasFewerThan(int points, String field) {
        this.matcher = new And(matcher, new HasFewerThan(points, field));
        return this;
    }
    
    public QueryBuilder not(Matcher m) {
        this.matcher = new And(matcher, new Not(m));
        return this;
    }
    
    public QueryBuilder oneOf(Matcher ... matchers) {
        this.matcher = new And(matcher, new Or(matchers));
        return this;
    }
    
}
