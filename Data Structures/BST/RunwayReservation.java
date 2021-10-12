import java.util.Scanner;

public class RunwayReservation {
	private static int n;
	private static int k;

	public static void main(String [] args) {
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt(); // The total number of requests.
		k = kb.nextInt(); // Grace time between requests.

		// Variables for getting the input.
		String cmd;
		int time = 0;
		String flightname = null;
		String flightnumber = null;
		String source = null;
		String destination = null;
		int curtime = 0; // Current time, initialized to 0.

		// An array of requests. This is the data stored outside of our binary search tree.
		Requests [] reqs = new Requests[n];
		int i = 0;

		// Reading the input. All requests are read from the input file and stored in array reqs.
		while(kb.hasNext()) {
			cmd = kb.next();

			if (cmd.equals("r")) {
				time = kb.nextInt();
				flightname = kb.next();
				flightnumber = kb.next();
				source = kb.next();
				destination = kb.next();

				reqs[i++] = new Requests(cmd, time, flightname, flightnumber, source, destination);
			}
			else {
				time = kb.nextInt();
				reqs[i++] = new Requests(cmd, time);
			}
			kb.nextLine();
		}

		// TODO: Code to process each request and solve the Runway Reservation problem.
        BST bt = new BST();
        int temp = 0;
        int last = 0;
        for(int j = 0; j < n; j++) {
            if (reqs[j].getCommand().equals("r")) {
                    if (bt.pred(reqs[j].getTime()) == null) {
                        if (bt.succ(reqs[j].getTime()) == null) {
                            bt.insert(reqs[j].getTime(), j);
                            temp = reqs[j].getTime();
                        } else if (bt.succ(reqs[j].getTime()).getTime() - reqs[j].getTime() >= k) {
                            bt.insert(reqs[j].getTime(), j);
                            temp = reqs[j].getTime();
                        }
                    } else if (reqs[j].getTime() - bt.pred(reqs[j].getTime()).getTime() >= k) {
                        if (bt.succ(reqs[j].getTime()) == null) {
                            bt.insert(reqs[j].getTime(), j);   
                            temp = reqs[j].getTime();
                        } else if (bt.succ(reqs[j].getTime()).getTime() - reqs[j].getTime() >= k) {
                            bt.insert(reqs[j].getTime(), j);
                            temp = reqs[j].getTime();
                        }
                    }
                    if (temp > last)
                        last = temp;
            }
            if (reqs[j].getCommand().equals("t") || j == n - 1) {
                int prev = curtime;
                if (j == n - 1)
                    curtime = last;
                else
                    curtime += reqs[j].getTime();
                System.out.println("Current time = " + curtime + " units");
                Node toPrint = bt.min();
                if (j == n - 1) {
                    while(toPrint != null) {
                        int req = toPrint.getReq_index();
                        System.out.println(reqs[req].getAirline());
                        bt.delete(toPrint.getTime());
                        toPrint = bt.min();
                    }
                } else {
                    while(toPrint != null && toPrint.getTime() < curtime) {
                        int req = toPrint.getReq_index();
                        System.out.println(reqs[req].getAirline());
                        bt.delete(toPrint.getTime());
                        toPrint = bt.min();
                    }
                }
            }
        }
	}
}
