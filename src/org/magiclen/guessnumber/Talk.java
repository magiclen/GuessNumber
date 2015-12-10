/*
 *
 * Copyright 2015 magiclen.org
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package org.magiclen.guessnumber;

/**
 * 辨識語句用的Talk特徵。
 *
 * @author Magic Len
 * @see UserPlayer
 * @see ComputerPlayer
 */
public enum Talk {

    START, FINISH, GUESS, GUESS_FAIL, BYE, HINT, RESPOND, HELP_GUESS;
}
