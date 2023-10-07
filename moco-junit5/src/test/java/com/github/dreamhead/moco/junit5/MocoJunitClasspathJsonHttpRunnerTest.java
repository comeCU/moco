package com.github.dreamhead.moco.junit5;

import com.github.dreamhead.moco.AbstractMocoStandaloneTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.IOException;

import static com.github.dreamhead.moco.helper.RemoteTestUtils.root;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@ExtendWith(MocoExtension.class)
@MocoHttpServer(classpath = "foo.json", port=12306)
public class MocoJunitClasspathJsonHttpRunnerTest extends AbstractMocoStandaloneTest {
    @Test
    public void should_return_expected_message() throws IOException {
        assertThat(helper.get(root()), is("foo"));
    }

    @Test
    public void should_return_expected_message_2() throws IOException {
        assertThat(helper.get(root()), is("foo"));
    }
}
