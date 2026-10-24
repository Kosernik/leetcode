#include <iostream>
#include <string>
#include <vector>

using namespace std;

vector<int> daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

class Solution {
   private:
    int parseDateToDays(string& date) {
        int month = (date[0] - '0') * 10 + (date[1] - '0') - 1;

        int parsed = (date[3] - '0') * 10 + (date[4] - '0');
        for (int i = 0; i < month; i++) {
            parsed += daysInMonth[i];
        }

        return parsed;
    }

   private:
    int helper(int& arriveA, int& leaveA, int& arriveB, int& leaveB) {
        if (leaveA < arriveB) return 0;
        int result = leaveA;

        if (arriveA < arriveB) {
            result -= arriveB;
        } else {
            result -= arriveA;
        }

        return result + 1;
    }

   public:
    int countDaysTogether(string arriveAlice, string leaveAlice,
                          string arriveBob, string leaveBob) {
        auto arrAlice = parseDateToDays(arriveAlice);
        auto lvAlice = parseDateToDays(leaveAlice);

        auto arrBob = parseDateToDays(arriveBob);
        auto lvBob = parseDateToDays(leaveBob);

        if (lvAlice <= lvBob) {
            return helper(arrAlice, lvAlice, arrBob, lvBob);
        } else {
            return helper(arrBob, lvBob, arrAlice, lvAlice);
        }
    }
};

int main() {
    //string arriveAlice = "08-15", leaveAlice = "08-18", arriveBob = "08-16",
    //       leaveBob = "08-19";
    string arriveAlice = "08-15", leaveAlice = "08-18", arriveBob = "03-16",
           leaveBob = "05-19";

    Solution solution;
    int res = solution.countDaysTogether(arriveAlice, leaveAlice, arriveBob,
                                         leaveBob);

    std::cout << res << std::endl;

    return 0;
}
