/**
 * 
 */

class Handler{
	constructor(){
	const ui = new Handler()
	}
	
	ui.deleteMemberCallback = (id) => {
	    console.log("Delete button of member with id ${id} was clicked.")
	    const member=ui.getMember(id)
	    console.log("Member is ${member.firstname} ${member.lastname} with telephone ${member.phone} and address ${member.address}.")
	}

	ui.editMemberCallback = (id) => {
	    console.log("Edit button of member with id ${id} was clicked.")
	    const member=ui.getMember(id)
	    console.log("Member is ${member.firstname} ${member.lastname} with telephone ${member.phone} and address ${member.address}.")
	}
}