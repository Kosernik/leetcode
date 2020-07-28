package ExploreCards.Trie;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromePairs {
//["hgcdijcafg","hdhcjjbbiicjdiche","aiiffjdgcibj","jgcecajebbd","ihcbgahfdgjfhcd","didaffahaifdefgabb","gcifchhejbjfha","dfgceegegbda","afhejfijedgegi","aahaaaheje","iagcddhebdfejfdgi","gjdb","ajhjgbchjeiia","gaebdhacjhehagacadh","e","gajgbedaidejcfh","jiaahjfdahbfhdea","addeieh","fjcgdcbee","jhiddcjchgd","eijcgieghbadce","hacdjhceigebb","gdffia","iaijfgdia","fcjagbeb","hddaeb","fgjejdhcgighgcchg","aggidhfjf","bigcigcai","gcgccdha","gei","jceeciecjjfbhdgjbcb","j","ejbdcahfd","gca","iadhbedahc","bgghdhcfghcejaggidh","bfedhdjijeafh","djfcf","c","iggbheejbijhhja","iiecdifbabadde","hihfijhbfddhibaaia","cdfcd","adh","bbfehfc","gee","diffddejbeeigc","eccdbbgfehecjic","ga","ifjadgaegdfg","chicjgaaiiejbjbejgd","ehidihebj","bgegjcigfbi","hdbbbeaiibagccih","dgegb","abheige","gcbfajieaighebdfaa","ebgjcec","gfgdeja","dejha","ceii","hcdfjicajea","egbajejfaif","dhigfdahfhfhieb","jdbgdigfjeacdaj","ajadfc","bjghegcbd","ebieieigi","dgde","abiidichhaefd","ieabjajidgccebg","cgbafgj","iieiadfjggad","heefbjjaejfabjgeed","chjhhgdhjafggiaaec","ajdhcghbe","iega","ibehhieidb","jfhbgegijbcddfddhhhh","idbgahdbjhbbi","jcbeefdffaibe","ajhjgacfhahadddefecf","eaadbdeb","dghdffda","jehaijaiicafh","ghecjdic","aeddjdigdcj","haegdccdhd","jechead","aa","icciadijc","igb","jcegiigbeacfhgbadc","dcgiaj","cafb","cdjggbbi","ecjdeahjc","aaee","jbgeccfceigcigbh","hcahdabjjcbfjjfdi","aebiiibddafefihea","gccjheffhegdd","gicidfcgb","iha","hheddbbcbcfdhiebfg","ebbjjg","bjbbbafdeagieieef","cjafjafjicgdfbj","chddigabfibcfjff","cbaeeebbhdiad","bbccdggjad","bbibfi","cfijgdfcefa","fccdb","hffjiha","gehheafhgd","dbgafgjhdajjci","fjfjdiffdcb","fabaeda","jed","fibcgjbiaeg","hfiaj","ffae","eiaaedeihfbicjhcdgci","jceiah","iecich","ajeehhcceeabb","gcigdc","dec","bigich","ibdgg","bfhjeigbgihfc","chcfdhja","biacgc","fagcghihjdfjdbeicbi","dd","dicifiaejcihebighf","fjddehjf","ibdfbhgadjb","ahajhjcjccehehhdffef","dcgiah","fddbfgjf","igihgieei","hbgegaedjdeebfdjcbe","jgedfaddfecej","fibdfiedfdaie","bejidjibihfggbgfdei","fgiccihhdibc","fifjf","dicejfgcd","hibeehfajggeihhfge","agbjj","ibjgic","ibbeibaaacibffadbfed","abjbhddjbj","ii","ajbajjfh","bbfhdbcjefdfbjh","aiihbdbfih","dgedcgjiije","jhfaigbabhhfec","fdbiejiagdfbagdabcea","fiefghgig","eiejdhjb","dhecfaba","cehhcbdj","hegfejcdf","di","dfeegj","abacdeha","ihfffggcfajbedgjaic","ajfibhhbda","eehfcccdacfeji","ehgccbbidaegggciif","jfgieibdcbaihegfg","gicaidaijebheid","cjbdcbfacc","dhbfeeahgddhi","hihejjaidjfe","hgabiecbeigcf","dccfe","hbij","gbciefigd","jdhegigcficahacgee","jiegebbdaa","eiaieecf","eifa","hhgfeafgijcfddjajbhe","fhdd","dcih","cg","cajfbhjibggfigdie","egaeabeefd","aiedbejd","bacaifcfdeiceffbgbbj","jfd","abhhd","fhfebeajjefehi","efifefdebjdejiih","aeciieidfgdjgcgjicjc","chj","dffe","bifegdeacejddgdiiag","ciihdbcbajehcjbaeiai","eabggeae","debedbccheddaaebgg","gifh","jcgjigdehdbcfdgabch","dcgcgchahhj","ae","jfgj","gjgaeiebbhjccghgig","fjeaicijjdhdibhbba","dahah","jiiajjhfaeaeghgiid","gbg","hfcjiiegfcjah","jhccachhhgbc","baabdgfejhbecbdhg","cdje","ehjdjihbedcdf","hjgahbda","biegjhjedbhbejg","iebdfdcbihfjaidb","gcfjiajijjecg","hfebecacidffiagfb","jajhagfhbccjaajjb","bhjjcij","hdgihibdhebbddjh","eaaaadhdhcbadcceeh","dacddcidhf","dagjddgejgajegea","fbjgiaadh","hcfjhfifcdaga","gjbggedgbcdfcdji","hebihjc","aigbcaffdicdafbbcfa","fjdfhiaahhaebiaciccj","aegfgdciadieaj","gedghdach","jcibbggjebbebifc","dhaii","eieibfjfccihdj","gaigchdffc","difjfc","jeabfccaegdcjffhi","dadfhabgehfdfhefhe","idigghceih","iiaececgcffagfeagh","bcbgfjiieccfca","fhci","jghigfggbef","hjdch","idgiciiajcf","a","fidghajheffigfdb","dbhjifidd","d","fbbhjbfg","ihaf","dhc","aahgdifidb","ji","cebgf","fgieidccefe","ehcbchecaaeai","jgffgjgcbbfcicjfd","hhi","ggdeddbiecceheaea","ijijebcaacdgi","acdjde","hgdaf","iifcghdhighgge","aagejefghf","ai","dcieja","fdjacgdab","ichgdiigfchddae","ceheddjebfahcadgccdg","ijghihcgf","ibacfaid","gdchicfjggifbdfcg","jgfjehc","jagijceajhagfajba","jcfchfchgdddajjgchd","ffjddhi","aaeaafaaedhcjbj","hghgifdfdaeaj","ejhfciegia","deiffebc","bfaffdfhacchgbb","ehjhi","cidbggbcfj","begfihdjccjbddcbc","gfdda","aahddfbjgfdcfdieghi","ajdchedbhhhfecfd","ijiaebeic","cfehajbfbjf","gfcjhfbii","ifcfggbjafhecifh","ejjifhb","jeebcbggediiaidi","ciaicgigidj","f","cfhcadjijej","bcfbfdffee","bdaaaddffdh","idhbbhj","eehjdbidgca","aegdejaaibcghdieb","gijigjagcghbj","jibbebhie","cfihcdffbhjfigecdda","adgbfcifgfijjeb","ifaeabcgbejefgfgad","bgacihegfdcbdeeeb","abecfcffdadjhfhf","hd","idhfjeecbijaaffi","bbd","ebaahjcbhcged","bdidfegjedfbjgdch","fd","jga","ahagijfhibjcgihcbidj","jegaeebdcci","diahdigcgaifcbjgg","jbg","efe","gfcfabhehifhefgcc","bejiebdjfjbigbeejab","gac","bbagi","jeegcahiedaf","cbafgdjejd","gdijhdgaafce","jhbiehgbecgffjfci","fhehgafhigacfgffj","fefj","cichja","bfjfjeige","ihijabibfhfabaihd","hjfdjjggbcidhghahij","bddiabafccbe","iggf","haajbadeedhfdeb","abebjhdidhjabb","hdhghfegacgdghcide","dggajgdfajedjecgg","hcjfidjjhjfbba","gabdagcfgifeggfedfj","hgaidhii","agie","bcfcggjiafeciijddcha","eifdajhffbjfcgcf","ihdecfeacddg","bcdifdg","iefbcicfdcdfgfhbg","egfecijeaebbgfabd","jcbiedihbibad","ejf","ffjd","cdgciabcefcfeciiiij","efdfbdhhhhhh","hi","eifejejebagfjgfihbhj","haebfbbhgfae","aeejdhfhefdacf","adbbacijfj","ghadc","eaabajabibafiehgfd","gfiad","adfcacfebhc","cdahf","ijgaacdfj","h","fbgedagjcbhfb","jeciaijbghieaijiga","bdfec","egbjgjgggfe","fabhjdcahbfhhej","dhdgiggaja","gbaifgbjgchjjahac","gagdaehcji","jcijgigeaaffiehfddei","ijbfgbciacgcaec","idcehfggjfhaifhcfg","cheggajbhighbedfffie","hegbffaghbjgjddjdba","dcbjecigfdehb","bjjjbhg","iadb","cjjbhae","gcfggjfdcej","fdahjec","eafiddbbhidcihj","fccihbe","jbcbijebehdj","ad","egfceagadfgf","ccgiedgceehbi","ibha","aaeigcfjghach","bahddjdhddhdjbja","adjfggeedfbeae","gfchfai","hhhejhfb","eieg","ajahchgjijdagji","adaifdchbgchgihghg","aiahigcfdbdac","ieihgdddbj","hcaeec","bhfajeeaigeed","fbddehcjihahaijh","aajdiebd","dfjcijcjg","jebcjhfbhg","djifehdajb","hfejgagdjca","fdgaabaee","ie","hcfcdbjdgeiibfdga","jhbhffeaj","cijdfahdgebchjhjacjg","aebacch","gdjbdfhcgecbaicc","ieadfbabcfbeecadaffd","hfbafdedjbj","jejhehdggdjde","eiijjjbeiehggihee","ejbjbfj","ehbbic","bgfjfjhgdfjegdjgib","jg","jchdhdfea","fcjjefajjbedf","gehejhabgbiddiaccji","adcfecige","dfjjghhcbaajcf","cecdjadchfgjcbgej","ba","ciicjci","fejdicfchgaicehgbca","da","ghedgjhdbdeajjfef","gehhj","dbfcc","gcddhiagdigfc","aajhibbfagjfjdhb","ffgj","eceihceahghhdfjdfh","jffgg","abfdcffei","jghfeajch","ddhibeaedhfgi","jaibbibddeeaig","gedjeibija","hgcdeiehi","cfdeehjaccd","fbdbahdfgiaabgc","hj","cfiddcacgcfhjaaifbhh","aciheediefdafjijg","aajfajbjbijdjegdhga","i","hbccbdhijifgddgb","abadfahcdhj","cjggj","gjhcdggbfgib","abcfcjg","dahfaeaehfgggfeedgh","gdabbhbegcdafb","fbbjecjbgh","beebcdiaj","gbchfjfcaibjfddj","chcjjfjhe","jhaf","ahhihfgjdggjhgej","iaaafjeghffaba","ebjdeifcbjcacfjg","ahgfiedjef","jdhjhihhhajahicgjie","djjiaiiif","feg","djbefdhffafaehf","ggfgicjheb","fbhachji","fdahacjhggdijfeae","aheh","gjcjjgcaaifecfebfijd","djjecigagjcdhahdgc","fafiecfghic","eggdhcbfjfceha","geegafecdccafija","djbbaeihgj","cjfjeabbhfhb","aibjbjabhafdccif","dbfeiigacbfijgdhade","gabgjiffiejhhbib","hjfeadh","bafdb","biefdf","eeibdieeadadhhddcb","bjjdjjfdfaadji","aaidhc","jigcbijgbgjahaiiibje","hafjj","ghiijcfcajcaiefhddd","jjffbjjch","hbjfcdjjdafai","fhchadddhh","jeejidhecg","adghfjgcdjafhaehibjc","djcifidhhddb","fhebhgbedeccjhcgjgh","efbfjdfggjebfchaacd","gdbb","gbaf","gacbaacbjfifejgigecc","ajijhcgbcc","baf","ahhdhaabhcced","fbbadad","chcgehhfegaf","hahihdefj","cjbihiffbjjiijdfj","fififaehjgajhbg","jbagbahjchgjehaii","ihcaaaihdagagf","ifijiiaagfcidcieg","agicdhfdahai","acaijdhjhafciicgdf","idcebggjgieahjcggh","ebhhcgj","bjefjdehhgfgd","hbfgegj","ibegbejchdj","edgfhfbgbiggeg","ccbbaj","cibgijf","bhidhgfbfehedcdgdafe","jfgga","ddfiebagiij","hjjhccefaabifh","eijbfebhccbd","agcehcjhffcjgjhgdd","ajidaddfgie","aiehcjbgahiiicgdb","fgieghhfegajaejadjb","cfdgbbeafhgeg","chedjgf","igfabbfabbebgcegd","cedbfghbaidgeagggb","ggdbgifbbfdff","ahagjahaefghggh","jfaghjhd","bfbjajededhcj","jgcgdbg","hggg","febgdajcedajcgbjfg","hhhidja","fceebciibfeechehi","geajbgde","gjhcaadfihhff","jgajicjb","dhghjdc","jjbibididhfjabceb","hedahgicdjcjbefbgh","jjhhdgbafgbjbej","hgjdeejheafidej","aejfiae","jdhgfbaai","jdcbjibgijbd","gffebiaccj","ejfbiaideb","fhedcbjcc","daceijchabifbjjag","gecaa","haihc","cbcbfbeijdf","hcfheehbhfdfccbcgad","jcdji","hichdcahiifbah","bfb","aahhjahacec","aecihibgfcdjdbfd","fbgcifjghebhgefjjhgg","hhhabbjgcicdehfeffcc","bdeahgjjahhhejfh","ejceefififb","jajih","idibghgiehddfcabh","jeiichdafbcbjai","adfbbgdg","aieib","ddgbhgccb","ef","ghgdgcijjhehidbcbdce","cehadidf","jjgjhhfajcgifidbajff","didhfdjbjg","cgaebeicgegecbg","ibi","dcgddijiccibibb","gfchegjjiedfcfdhchd","jd","cdfabddfbfiijce","bc","bbgfhechfhfjdfch","adjfjeehgjeebjeaeb","cjhjdecgieaidgccg","cdfbdcdbfaigd","bdcaceegjcbdigcadeb","fggb","chghcegbcedacab","jgejehdgfbeiihfadg","dfccdcjdjigb","cdag","afbhegiffjhfha","ac","ed","abbdadfei","eecihfbaijf","aaae","hjijdfidfebbff","eecjadbadfjag","fdbbh","jfbfchabhcgg","ecdcgcjdcddbdbhbjh","baidbgjcgejfjegb","ghfgbhejdigab","ficjccjafhdjbgeia","hdad","dighaa","cfhfhai","bicgcgeaajegbhgfij","babjjjj","jbfeihhgjb","dfbei","accabbjcehiaha","fabibjhabhji","bjhfbgicffchiagjbg","ebgciefhjbfdefjei","fcb","jbfhgdfaehjehjd","adgceiijjehhgjfb","acjjfgjhh","jjjghcjbcf","hihdeiibcceib","bjeaiehjdibfhciaibhd","jafjgcheedaeah","fdiaeicgcafghjbic","ajjhfjdhdi","ag","dhjidegcjgdbbafi","ebiddfcajaebig","ggbdcifbbccbg","gfiajjb","chfj","djhddeibejhgieecjdji","ahjjecdedehcdda","dagjhcidabccacacaf","aedfibdhbdiaiaaie","gdaebbccfeajdbaahih","idigjbjhfcjbh","cb","hfgdaaifaechjffbbb","dijhcfddifha","aecbjjcjficadcjaf","gcbeifgh","cibfbhdieiicb","cgjijddiehidjaic","haieicheadhcgfe","gagdebjc","hhjggeijdafccejah","bdceb","cebcec","bajbjhfdadffefibija","fgcafihjgibejehhibc","cfdb","bgeahajhjjcdedcedfah","ejaaigdicbecea","idddhhedcf","dbfjhhfhhijf","ddaehgigbdjg","cic","gefhbdcaaajfei","fdbgcfcbcajgche","hcgffba","dich","bdicic","egebgfhddbdcibeeh","fefcde","efej","gedjfedj","gg","bceig","bcggggaf","aehgda","jadjbjddhiic","ahfbdbfeiag","cjhfgg","hjig","dhcedhcgfcjd","ehgfacbcchgcjbjdd","ejh","gaabjijcabige","fdhafgdagjhjgjiefcb","bhgdhbiddjbjbgefj","fdaeddjdaifih","jdeidhde","ia","efadccghfc","bb","bihdideifhe","behade","jjeiifabcdcgeadd","iiaaagigecjdhe","fjbbc","dijjdihe","bjbhjafdccddhb","bfaedfgabbiieede","agfbajagdeahcjif","jdeja","biea","ggefahhcjfghdehagbjc","hggaichdgbgiajcfifj","aaadbchdcjiajhj","abjdfdgcfahcidicc","ifdjfiabj","ceadajabcggfciicaj","bfdfahbcdfbd","jdeb","fbaebchja","ahdfibagdaacafcd","fjdagfbb","gegfbbedccjiagdbagf","df","fiajciggdffbibh","gehejefdehgfhigeh","diajcbdiicdbjadbg","bdjhbbcjii","ighajdbhhdfhhe","abgjjgidb","jjjghfadedefd","affdejiceb","ejabfgeffhgccbhgch","jgg","jac","ffchfcei","hgeajjbchihd","cajege","ffijahdgfh","cfcghedahc","gjgebjigfjc","bjdfjjhedbhaedge","adehfehbfigdadeiia","ehbhddiehcieecaiiga","ddeabjaaf","gjjgahjfcafddjhfj","iheahbiifjcchajcbbji","fjgdgbhfcbdhc","gbifcige","bhfjihcdehcfd","ichiihef","fjjjbjbh","aiggiihagacja","gbdababgdigebgf","jdbfcbaieg","fffbcdfchichcfcddf","fdfdcaehajd","jjibhhfcfcdffijhebii","bcjjbaajehj","igibjd","g","hfibfh","cegaabia","geieabefagh","edeicaefdfgdej","iia","che","aaeacciajdjdahhge","fchi","cf","hbiegdhfebiggahaji","eeicf","abiajjfgaghhgdch","aifcbeibcc","bidibjehffagbcdg","dijfeead","edehadcfgbgegbbhcade","jffdbfceiab","ci","bjchhafaihdfejabfc","jgiabeahgegdhd","ijdjhf","fdiccdidddieibgajed","fheb","fadeihejj","ejaaegafhfc","hhabejee","hjfhbfa","dhdadgd","bjhicjcgedfg","badgji","bajfaceffdbjhda","jcghedfciad","eiedbcdcjeedjdfcgcg","if","ehjif","iihdeiiacjjhagef","jhjfgedabffic","faegdea","chif","gaaibhj","egagibabajicfaddaeea","gcdcbiicichb","afhideagha","hifbbfdjchaba","jdcej","aebjeagjgbgcfhfjj","dhj","ificabhgijffjh","efhafbbgc","debbcfgifdceiedjeb","eiiadhfhajjadcib","bejdidb","jgbccggddbe","bjcddbhh","ccdjefbf","hgjdghbd","behfjgj","feffedefjbbciifbbief","decggbfcafefh","fafdja","eb","dbabee","echicbdaefjfc","hbhhbcbahja","dcchfgiagefibh","gbebdfcjgjjhice","adeeaijhe","dgfdbjhfhbcfaci","be","hc","hefdheedfcghahcc","bfefjeideabde","jjdcdbbbbdbd","jbec","bbjbgbbjahhghgdb","gbcgiced","beeeihacdgdc","jb","bcejbfhciaicajaebiea","cbhfajeefjjbj","jegda","bdbia","cabcacafahdfbh","iafbf","fejihaabbffadijibejb","egchcaigdhdf","hijeaacjgeifi","ced","beaeb","idfhech","ffabdcaieeedbhg","jf","ejadchccdefgbdja","idhehhjgead","gbdeabag","ifgegcacb","jdjacighjad","faecibgja","jbchahaff","cbcgdfeddcj","bffcdc","ifajdbihfcf","jdie","ihgdiajfjjbca","hifgbbhiihcec","fcbgchidjhdhiefj","fehcadbaj","fifajahfajdj","cadcigi","fgfjgfdbcbhbc","fcbgebhgjhhahb","gghjffg"]

    public static void main(String[] args) {
        PalindromePairs solution = new PalindromePairs();
        String test = "sssll";
        System.out.println(solution.isWordPalindrome(test, 1, test.length()-1));
    }


    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> pairs = new ArrayList<>();
        if (words == null || words.length <= 1) return pairs;

        TrieNode root = buildTrie(words);

        for (int i = 0; i < words.length; i++) {
            searchInTrie(words, root, i, pairs);
        }

        return pairs;
    }
    private void searchInTrie(String[] words, TrieNode root, int index, List<List<Integer>> pairs) {
        char[] letters = words[index].toCharArray();
        TrieNode currNode = root;
        for (int j = 0; j < letters.length; j++) {
            if (currNode.index >= 0 && currNode.index != index && isWordPalindrome(words[index], j, letters.length-1)) {
                List<Integer> pair = new ArrayList<>();
                pair.add(index); pair.add(currNode.index);
                pairs.add(pair);
            }
            if (currNode.children.containsKey(letters[j])) {
                currNode = currNode.children.get(letters[j]);
            } else {
                return;
            }
        }

        for (int idx : currNode.indexes) {
            if (index == idx) continue;
            List<Integer> pair = new ArrayList<>();
            pair.add(index); pair.add(idx);
            pairs.add(pair);
        }
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            fillTrie(root, words[i], i);
        }
        return root;
    }

    private void fillTrie(TrieNode root, String word, int index) {
        TrieNode currNode = root;
        char[] letters = word.toCharArray();
        for (int i = letters.length-1; i >= 0; i--) {
            if (!currNode.children.containsKey(letters[i])) {
                currNode.children.put(letters[i], new TrieNode());
            }
            if (isWordPalindrome(word, 0, i)) {
                currNode.indexes.add(index);
            }
            currNode = currNode.children.get(letters[i]);
        }
        currNode.index = index;
        currNode.indexes.add(index);
    }
    private boolean isWordPalindrome(String word, int left, int right) {
        char[] letters = word.toCharArray();
        while (left < right) {
            if (letters[left] != letters[right]) return false;
            left++;
            right--;
        }
        return true;
    }

    class TrieNode {
        int index = Integer.MIN_VALUE;
        Map<Character, TrieNode> children;
        List<Integer> indexes;
        TrieNode () {
            children = new HashMap<>();
            indexes = new ArrayList<>();
        }
    }

    // TLE
    public List<List<Integer>> palindromePairsBrute(String[] words) {
        List<List<Integer>> pairs = new ArrayList<>();
        if (words == null || words.length <= 1) return pairs;

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i == j) continue;
                if (isPalindromes(words[i], words[j])) {
                    List<Integer> currPair = new ArrayList<>();
                    currPair.add(i);currPair.add(j);

                    pairs.add(currPair);
                }
            }
        }

        return pairs;
    }

    private boolean isPalindromes(String left, String right) {
        char[] leftLetters = left.toCharArray();
        char[] rightLetters = right.toCharArray();

        char[] letters = new char[leftLetters.length+rightLetters.length];
        System.arraycopy(leftLetters, 0, letters, 0, leftLetters.length);
        System.arraycopy(rightLetters, 0, letters, leftLetters.length, rightLetters.length);

        int leftIdx = 0, rightIdx = letters.length-1;
        for (int i = 0, length = (leftLetters.length+rightLetters.length)/2; i < length; i++) {
            if (letters[leftIdx] != letters[rightIdx]) return false;
            leftIdx++;
            rightIdx--;
        }

        return true;
    }
}
