/* ###
 * IP: GHIDRA
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/* Generated by Together */

package ghidra.program.model.listing;

import ghidra.program.model.address.Address;
import ghidra.program.model.address.AddressSetView;
import ghidra.util.exception.NotFoundException;

/**
 * A <CODE>ProgramFragment</CODE> is a set of <CODE>CodeUnit</CODE>s that have been
 * bundled together with some additional information such as a name, comment,
 * alias, etc. Every code unit in the program is in one and only one fragment
 * so the fragments form a partition of the program. Fragments in turn are the
 * building blocks of <CODE>ProgramModule</CODE>s. Program fragments and modules 
 * allow the user to overlay a hierarchical structure upon the program which can then 
 * be used to control viewing and navigating the program.
 */
public interface ProgramFragment extends Group, AddressSetView {

	/**
	 * Returns whether this fragment contains the given code unit.<P>
	 * 
	 * @param codeUnit the code unit being tested.
	 * 
	 * @return true if the code unit is in the fragment, false otherwise.
	 */
    public boolean contains(CodeUnit codeUnit);

	/**
	 * Returns a forward iterator over the code units making up this fragment. 
	 */
    public CodeUnitIterator getCodeUnits();

    /**
	 * Moves all of the code units in a given range into this fragment.
	 * Note that <CODE>min</CODE> must the starting address of a code unit
	 * and <CODE>max</CODE> must be the ending address of a code unit.
	 * Furthermore every address in the given range must exist in program
	 * memory.<P>
	 *
	 * @param min min address of range specifying the code units to move
     * @param max max address of range specifying the code units to move
	 * @exception NotFoundException thrown if any address between <CODE>min</CODE>
	 * and <CODE>max</CODE> (inclusive) does not belong to program memory.
	 */
    public void move(Address min, Address max) throws NotFoundException;

}
