import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class TestContainer implements Runnable {
        private Class<?> clazz;

        /**
         * Initializes a new TestContainer. A TestContainer is used to prevent certain edge cases such as infinite loops.
         * 
         * If an infinite loop occurs, the test will timeout and notify the user accordingly.
         * @param clazz The class containing the tests
         */
        public TestContainer(Class<?> clazz) {
            this.clazz = clazz;
        }

        @Override
        public void run() {
            try {
                TestManager.printTestCategory(clazz.getName());

                Object instance = clazz.getDeclaredConstructor().newInstance();

                int classTests = 0;
                int classTestsFailed = 0;

                for (Method m : clazz.getMethods()) {
                    TestCase testCase = m.getAnnotation(TestCase.class);
                    Tip tip = m.getAnnotation(Tip.class);

                    if (testCase != null) {
                        try {

                            m.invoke(instance);

                            System.out.println(ColorUtils.formatColorString(AsciiColorCode.BRIGHT_GREEN_BACKGROUND,
                                    AsciiColorCode.BRIGHT_WHITE_FOREGROUND, " PASSED: \u00BB ") + " "
                                    + testCase.name());

                            TestManager.submitTest(0);
                        } catch (InvocationTargetException e) {
                            System.out.println(ColorUtils.formatColorString(AsciiColorCode.BRIGHT_RED_BACKGROUND,
                                    AsciiColorCode.BRIGHT_WHITE_FOREGROUND, " FAILED: \u00BB ") + " "
                                    + testCase.name());

                            classTestsFailed++;

                            if (e.getCause() instanceof TestFailedException) {
                                TestFailedException tfe = (TestFailedException) e.getCause();

                                System.out.println("\t" + tfe.getMessage());

                                if (tip != null)
                                    System.out.printf("\t%s\n", ColorUtils.formatColorString(AsciiColorCode.BRIGHT_WHITE_BACKGROUND, AsciiColorCode.BLACK_FOREGROUND, "HINT: "+ tip.description()));
                            } else {
                                System.out.println(ColorUtils.formatColorString(AsciiColorCode.WHITE_BACKGROUND, AsciiColorCode.RED_FOREGROUND, "\tThe executed code caused the following exception. This is NOT the fault of the driver."));

                                e.getCause().printStackTrace();
                            }
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (IllegalArgumentException e) {
                            e.printStackTrace();
                        }

                        classTests++;


                    }
                }

                TestManager.classTests.set(TestManager.classTests.get() + classTests);
                TestManager.classTestsFailed.set(TestManager.classTestsFailed.get() + classTestsFailed);

                System.out.println();
                StringUtils.printTextCentered(
                        String.format("TESTS PASSED: %d/%d", classTests - classTestsFailed, classTests));

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }