package LeetcodeWeekly;

import java.util.*;

public class L5235 {
    public static void main(String[] args) {
        // int[][] matches = {{1,12},{2,11},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9}};
        // int[][] matches = {{1,3},{2,3},{5,4},{6,4}};
        int[][] matches = {
                {26651,85186},{19790,34845},{20238,59388},{12788,40994},{46703,28184},{49936,83960},{76158,33038},{96005,2100},{86989,72152},{73342,82931},{90852,54532},{61649,18655},{9506,73692},{56189,5503},{34939,78765},{98315,19818},{57974,42491},{5906,8266},{97215,95437},{48266,87323},{86578,82992},{29919,70323},{38749,98079},{10259,27750},{977,39147},{43625,38229},{56044,32634},{53509,13100},{59446,68045},{38379,7712},{87511,62110},{35456,508},{76381,89490},{73270,55169},{82004,20887},{11239,24195},{56561,57161},{96112,81582},{20403,76188},{77876,61782},{99546,39653},{68650,57489},{27952,11410},{10595,73394},{98154,49624},{10866,3758},{70902,97205},{43360,93218},{59119,82709},{7379,47660},{76950,1884},{20120,87138},{23010,5729},{96553,12208},{70423,36052},{98588,30989},{87447,24694},{90748,39031},{17455,13250},{49557,4501},{99624,72185},{24791,99744},{80458,57635},{16175,29359},{53170,83581},{95936,39348},{5634,95357},{58517,73348},{54861,34521},{86692,23939},{11623,85398},{7562,4748},{13217,29610},{52705,67263},{95277,68332},{50498,96263},{18070,33256},{1901,4237},{11894,97936},{22135,34362},{7698,64698},{22893,62847},{2294,14712},{69996,48778},{340,93723},{42138,33976},{53231,33755},{29512,501},{81773,58971},{19189,20321},{30220,37726},{78678,17938},{79172,26444},{67695,39219},{23206,40923},{5651,8928},{49333,29553},{98589,75052},{99636,94502},{38455,66022},{3654,56685},{42118,65465},{83831,62461},{81301,90996},{35209,23863},{99223,69931},{5206,42971},{2143,97501},{91454,60002},{6307,70975},{48194,6557},{60125,70237},{60551,85062},{58731,86177},{98064,94854},{63923,51970},{87687,36064},{37926,97759},{87685,22212},{62051,7149},{1430,13255},{55928,48428},{8319,99922},{58503,69220},{45821,70178},{56815,31101},{77963,7364},{28828,65658},{92037,99306},{97928,41984},{47086,73658},{35491,79727},{24688,42610},{32304,18289},{52770,31966},{96613,96122},{73643,49573},{27623,89143},{62163,93629},{41018,53285},{59655,4055},{80777,17295},{9744,38601}};
        /*[[26651,85186],[19790,34845],[20238,59388],[12788,40994],[46703,28184],[49936,83960],[76158,33038],[96005,2100],[86989,72152],[73342,82931],[90852,54532],[61649,18655],[9506,73692],[56189,5503],[34939,78765],[98315,19818],[57974,42491],[5906,8266],[97215,95437],[48266,87323],[86578,82992],[29919,70323],[38749,98079],[10259,27750],[977,39147],[43625,38229],[56044,32634],[53509,13100],[59446,68045],[38379,7712],[87511,62110],[35456,508],[76381,89490],[73270,55169],[82004,20887],[11239,24195],[56561,57161],[96112,81582],[20403,76188],[77876,61782],[99546,39653],[68650,57489],[27952,11410],[10595,73394],[98154,49624],[10866,3758],[70902,97205],[43360,93218],[59119,82709],[7379,47660],[76950,1884],[20120,87138],[23010,5729],[96553,12208],[70423,36052],[98588,30989],[87447,24694],[90748,39031],[17455,13250],[49557,4501],[99624,72185],[24791,99744],[80458,57635],[16175,29359],[53170,83581],[95936,39348],[5634,95357],[58517,73348],[54861,34521],[86692,23939],[11623,85398],[7562,4748],[13217,29610],[52705,67263],[95277,68332],[50498,96263],[18070,33256],[1901,4237],[11894,97936],[22135,34362],[7698,64698],[22893,62847],[2294,14712],[69996,48778],[340,93723],[42138,33976],[53231,33755],[29512,501],[81773,58971],[19189,20321],[30220,37726],[78678,17938],[79172,26444],[67695,39219],[23206,40923],[5651,8928],[49333,29553],[98589,75052],[99636,94502],[38455,66022],[3654,56685],[42118,65465],[83831,62461],[81301,90996],[35209,23863],[99223,69931],[5206,42971],[2143,97501],[91454,60002],[6307,70975],[48194,6557],[60125,70237],[60551,85062],[58731,86177],[98064,94854],[63923,51970],[87687,36064],[37926,97759],[87685,22212],[62051,7149],[1430,13255],[55928,48428],[8319,99922],[58503,69220],[45821,70178],[56815,31101],[77963,7364],[28828,65658],[92037,99306],[97928,41984],[47086,73658],[35491,79727],[24688,42610],[32304,18289],[52770,31966],[96613,96122],[73643,49573],[27623,89143],[62163,93629],[41018,53285],[59655,4055],[80777,17295],[9744,38601]]*/
        /*[[340,977,1430,1901,2143,2294,3654,5206,5634,5651,5906,6307,7379,7562,7698,8319,9506,9744,10259,10595,10866,11239,11623,11894,12788,13217,16175,17455,18070,19189,19790,20120,20238,20403,22135,22893,23010,23206,24688,24791,26651,27623,27952,28828,29512,29919,30220,32304,34939,35209,35456,35491,37926,38379,38455,38749,41018,42118,42138,43360,43625,45821,46703,47086,48194,48266,49333,49557,49936,50498,52705,52770,53170,53231,53509,54861,55928,56044,56189,56561,56815,57974,58503,58517,58731,59119,59446,59655,60125,60551,61649,62051,62163,63923,67695,68650,69996,70423,70902,73270,73342,73643,76158,76381,76950,77876,77963,78678,79172,80458,80777,81301,81773,82004,83831,86578,86692,86989,87447,87511,87685,87687,90748,90852,91454,92037,95277,95936,96005,96112,96553,96613,97215,97928,98064,98154,98315,98588,98589,99223,99546,99624,99636],[501,508,1884,2100,3758,4055,4237,4501,4748,5503,5729,6557,7149,7364,7712,8266,8928,11410,12208,13100,13250,13255,14712,17295,17938,18289,18655,19818,20321,20887,22212,23863,23939,24195,24694,26444,27750,28184,29359,29553,29610,30989,31101,31966,32634,33038,33256,33755,33976,34362,34521,34845,36052,36064,37726,38229,38601,39031,39147,39219,39348,39653,40923,40994,41984,42491,42610,42971,47660,48428,48778,49573,49624,51970,53285,54532,55169,56685,57161,57489,57635,58971,59388,60002,61782,62110,62461,62847,64698,65465,65658,66022,67263,68045,68332,69220,69931,70178,70237,70323,70975,72152,72185,73348,73394,73658,73692,75052,76188,78765,79727,81582,82709,82931,82992,83581,83960,85062,85186,85398,86177,87138,87323,89143,89490,90996,93218,93629,93723,94502,94854,95357,95437,96122,96263,97205,97501,97759,97936,98079,99306,99744,99922]]*/
        System.out.println(findWinners(matches));
    }

    public static List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> lists = new LinkedList<>();
        List<Integer> zero = new LinkedList<>();
        List<Integer> one = new LinkedList<>();

        HashMap<Integer, Integer> lose = new HashMap<>();
        for (int[] match : matches) {
            lose.putIfAbsent(match[0], 0);
            if (lose.containsKey(match[1])) lose.put(match[1], lose.get(match[1]) + 1);
            else lose.putIfAbsent(match[1], 1);
        }

        for (int cur : lose.keySet()) {
            if (lose.get(cur) == 0) zero.add(cur);
            if (lose.get(cur) == 1) one.add(cur);
        }
        Collections.sort(zero);
        Collections.sort(one);
        lists.add(zero);
        lists.add(one);
        return lists;
    }
}