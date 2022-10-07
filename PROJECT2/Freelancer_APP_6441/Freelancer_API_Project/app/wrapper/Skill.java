package wrapper;

/**
 * @author Arvind Sangwan
 * @version 1.0
 */
public class Skill {
	public int id;
	public String name;

	Skill() {

	}

	public int getId() {
		return this.id;
	}

	/**
     * This method saves the id of the skill
     * 
     * @param id - id of the skill
     */
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	/**
     * This method saves the name of the skill
     * 
     * @param name - name of the skill
     */
	public void setName(String name) {
		this.name = name;
	}
}
