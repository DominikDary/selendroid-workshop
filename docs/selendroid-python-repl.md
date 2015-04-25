selendroid-python-repl
====

This document describes how to setup a repl for [selendroid](http://selendroid.io) based on Python. It uses the  [Selenium Python bindings](http://selenium-python.readthedocs.org/en/latest/installation.html#downloading-python-bindings-for-selenium).

Overview
==

  * Installion and Configuration
  * Use the repl with selendroid

Installion and Configuration
==

  I'm using Python version 2.7.x on my Mac. The following packages you have to install:


    sudo easy_install selenium
    sudo pip install rlcompleter2
    sudo easy_install readline

In order to enable code completion you have to configure your ```~/.pythonrc```:


      try:
        import readline
      except ImportError:
        print "Module readline not available."
      else:
        import rlcompleter
        readline.parse_and_bind("tab: complete")

Next step is to configure your shell:

    export PYTHONSTARTUP=~/.pythonrc

Use the repl with selendroid
==

  After you have installed and configured your system you can use the repl. Please start first the `selendroid-standalone` server (please note that this example is based on the selendroid-test-app):

    java -jar selendroid-standalone-0.15.0-with-dependencies.jar -app selendroid-test-app-0.15.0.apk

  Please open the Python interpreter just by typing:

    python

  To use Selenium Python client bindings you have to import them:

    from selenium import webdriver;

  The test session can be started via:

    driver=webdriver.Remote(desired_capabilities={'aut': 'io.selendroid.testapp:0.15.0'});

  This will create a new test session and the driver is available under the variable `driver`. So if you want to get the current url, you can type:

    driver.curr

  and press `TAB` and then you will get recommendations about what methods are available.

Action Chains
---

  For interacting with the app based on action chains, you have to import:

    from selenium.webdriver.common.action_chains import ActionChains

  Then you can use them. The gestures documentation you find [here](http://selendroid.io).
