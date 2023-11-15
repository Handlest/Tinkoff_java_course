package edu.project3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static edu.project3.Utils.getAverageBytesResponse;
import static edu.project3.Utils.getMostCommonRemoteAddresses;
import static edu.project3.Utils.getMostCommonResources;
import static edu.project3.Utils.getMostCommonStatusCode;
import static edu.project3.Utils.getMostCommonUserAgents;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Project3Tests {

    private static final List<Log> logs = List.of(
        Log.createLog("217.168.17.5 - - [17/May/2015:08:05:34 +0000] \"GET /downloads/product_1 HTTP/1.1\""
            + " 200 490 \"-\" \"Debian APT-HTTP/1.3 (0.8.10.3)\"\n"),
        Log.createLog("185.40.8.59 - - [31/May/2015:17:05:36 +0000] \"GET /downloads/product_2 HTTP/1.1\""
            + " 404 336 \"-\" \"Debian APT-HTTP/1.3 (0.8.16~exp12ubuntu10.21)\"\n"),
        Log.createLog("217.168.17.5 - - [17/May/2015:08:05:34 +0000] \"GET /downloads/product_1 HTTP/1.1\""
            + " 200 490 \"-\" \"Debian APT-HTTP/1.3 (0.8.10.3)\"\n"),
        Log.createLog("192.168.0.1 - Riko [16/May/2018:08:05:34 +0000] \"POST /write/helloworld HTTP/1.1\""
            + " 418 490 \"-\" \"Debian APT-HTTP/1.3 (0.8.10.3)\"\n"));

    @Test
    @DisplayName("getMostCommonResources test")
    void Test1() {
        // when
        var mostCommonResourcesMap = getMostCommonResources(logs);

        // then
        assertThat(mostCommonResourcesMap.get("/downloads/product_1")).isEqualTo(2);
        assertThat(mostCommonResourcesMap.get("/downloads/product_2")).isEqualTo(1);
        assertThat(mostCommonResourcesMap.get("/write/helloworld")).isEqualTo(1);
    }

    @Test
    @DisplayName("getMostCommonStatusCode test")
    void Test2() {
        // when
        var getMostCommonStatusCodeMap = getMostCommonStatusCode(logs);

        // then
        assertThat(getMostCommonStatusCodeMap.get("200")).isEqualTo(2);
        assertThat(getMostCommonStatusCodeMap.get("404")).isEqualTo(1);
        assertThat(getMostCommonStatusCodeMap.get("418")).isEqualTo(1);
    }

    @Test
    @DisplayName("getMostCommonUserAgents test")
    void Test3() {
        // when
        var getMostCommonUserAgentsMap = getMostCommonUserAgents(logs);

        // then
        assertThat(getMostCommonUserAgentsMap.get("Debian APT-HTTP/1.3 (0.8.10.3)")).isEqualTo(3);
        assertThat(getMostCommonUserAgentsMap.get("Debian APT-HTTP/1.3 (0.8.16~exp12ubuntu10.21)")).isEqualTo(1);
    }

    @Test
    @DisplayName("getMostCommonUserAgents test")
    void Test4() {
        // when
        var getMostCommonRemoteAddressesMap = getMostCommonRemoteAddresses(logs);

        // then
        assertThat(getMostCommonRemoteAddressesMap.get("217.168.17.5")).isEqualTo(2);
        assertThat(getMostCommonRemoteAddressesMap.get("192.168.0.1")).isEqualTo(1);
        assertThat(getMostCommonRemoteAddressesMap.get("185.40.8.59")).isEqualTo(1);
    }

    @Test
    @DisplayName("getAverageBytesResponse test")
    void Test5() {
        // when
        var getAverageBytesResponse = getAverageBytesResponse(logs);

        // then
        assertThat(getAverageBytesResponse).isEqualTo(451.5);
    }
}
