/**
 * Laget av Magnus Ødegård Bergersen
 */
"use strict";
{
	{
		// const ui = new UIHandler();
		var teller = 1;
		var value = "-1";


		// const buttonElement = document.getElementById("getUpdates");
		// buttonElement.addEventListener("click", buttonWasClicked, true);
	}
	function init() {
		let url = config.servicesPath + "/updates/-1";
		const ajax = new AJAXConnection(url);
		console.log(url);
		ajax.onsuccess = oppdater;
		ajax.get()

	
	}
	function oppdater(m) {
		var data = JSON.parse(m);
//		value++;
		// var person = data;
		var table = document.getElementById("myTable");
		var i;
		var editButton;
		var deleteButton;
		
		
		for (i = 0; i < data.newMembers.length; i++) {
			var row = table.insertRow(1);
			var cell1 = row.insertCell(0);
			var cell2 = row.insertCell(1);
			var cell3 = row.insertCell(2);
			var cell4 = row.insertCell(3);
			var cell5 = row.insertCell(4);
			var cell6 = row.insertCell(5);

			cell1.innerHTML = data.newMembers[i].firstname;
			cell2.innerHTML = data.newMembers[i].lastname;
			cell3.innerHTML = data.newMembers[i].address;
			cell4.innerHTML = data.newMembers[i].phone;
			cell5.innerHTML = '<button type="submit" id="deleteMember'+data.newMembers[i].memberId+'" class="deleteMemberBtn" value="'+data.newMembers[i].memberId+'">Delete</button>';
			cell6.innerHTML = '<button type="submit" id="editMember'+data.newMembers[i].memberId+'" class="editMemberBtn" value="'+data.newMembers[i].memberId+'">Edit</button>';
			console.log(data.newMembers[i].memberId)
		
// editButton = document.getElementById("editMember" + i);
// editButton.addEventListener("click", editbuttonWasClicked, true);
			
// deleteButton = document.getElementById("deleteMember"+i);
			
// deleteButton.addEventListener("click", () =>
// {deleteButtonWasClicked({"id":i})}, true);

		}
		var btns = document.getElementsByClassName("deleteMemberBtn");

		for(let p = 0; p < btns.length; p++){
			let k = btns.length - (p+1);


		    var button = btns[k]; 
			button.addEventListener("click", () => {deleteButtonWasClicked(data.newMembers[p].memberId)},true);

// console.log(k);
		}
		var ebtns = document.getElementsByClassName("editMemberBtn");

		for(let p = 0; p < ebtns.length; p++){
			let k = ebtns.length - (p+1);


		    var button = ebtns[k]; 
			button.addEventListener("click", () => {editbuttonWasClicked(data.newMembers[p].memberId)},true);

// console.log(k);
		}
		

		
	}
	
	function addbuttonWasClicked(){
	    let tElm = null
		tElm = document.getElementById("mysecondTable");

		

		let url = config.servicesPath + "/member";
        const member = {
            'firstname': tElm.rows[0].cells[1].getElementsByTagName('input')[0].value,
            'lastname': tElm.rows[1].cells[1].getElementsByTagName('input')[0].value,
            'address': tElm.rows[2].cells[1].getElementsByTagName('input')[0].value,
            'phone': tElm.rows[3].cells[1].getElementsByTagName('input')[0].value
        }
        const ajax = new AJAXConnection(url)
        ajax.onsuccess = fikstabell
        ajax.post(null,member)
        		
        tElm = document.getElementById("mysecondTable");
// location.reload();
	}
	
	function editbuttonWasClicked(i){
	

		var memberIdElm = null;
	    memberIdElm = document.getElementById("editMember" + i);


		var modal = document.getElementById('myModal');

		modal.style.display = "block";
		
	
		document.getElementById("addMember").style.visibility = 'hidden';
		document.getElementById("editMember").style.visibility = 'visible';
		
		
// console.log(i);
	// console.log(document.getElementById("editMember" + i).value)
	    
		let url = config.servicesPath + "/member"
        const ajax = new AJAXConnection(url)
		ajax.onsuccess = updateText
        console.log([memberIdElm]);
	    ajax.get([memberIdElm.value])

	  	memberIdElm = document.getElementById("memberId")

		

		  
	}
	function updateText(m){
		var person = JSON.parse(m);
		console.log(person.member.memberId);
		console.log(person.member.firstname);
		console.log(person.member.lastname);
		console.log(person);


		document.getElementById("medlemsIdeen").value = person.member.memberId;
		document.getElementById("fornavn").value = person.member.firstname;
		document.getElementById("etternavn").value = person.member.lastname; 
		document.getElementById("adress").value = person.member.address;
		document.getElementById("telefon").value = person.member.phone;
		
		

	}
	
	function skiftebuttonWasClicked(){
		const memberId = document.getElementById("medlemsIdeen").value;
// console.log(memberId)
        let url = config.servicesPath + "/member"
        const member = {
                'firstname': document.getElementById("fornavn").value,
                'lastname': document.getElementById("etternavn").value,
                'address': document.getElementById("adress").value,
                'phone': document.getElementById("telefon").value
            }
            const ajax = new AJAXConnection(url)
// ajax.onsuccess = viewMessage
            ajax.put([memberId],member)
            console.log(memberId)
	}
	
	function deleteButtonWasClicked(i){
	    var memberIdElm = null
	    memberIdElm = document.getElementById("deleteMember" + i);
	    console.log(i);
	    console.log(document.getElementById("deleteMember" + i).value)
	    
		let url = config.servicesPath + "/member";
	    
	    const ajax = new AJAXConnection(url)
// ajax.onsuccess = oppdater
	    ajax.del([memberIdElm.value])
// console.log("Da er en medlem sletta")
// console.log([memberIdElm.value])
// location.reload();
// init()

	}
	function fikstabell(){
		let url = config.servicesPath + "/updates/"+value;
		const ajax = new AJAXConnection(url);
		console.log(url);
		ajax.onsuccess = oppdaterTabell;
		console.log("fiksetabell()")

		ajax.get()
	}
	function oppdaterTabell(m){
		console.log("oppdaterTabell(M)")

		var data = JSON.parse(m);
//		for(var i; i < data.newMembers.length; i++){
//			document.getElementById("myTable").deleteRow(i+1);
//			console.log(data.newMembers.length)
//		}
		
		var table = document.getElementById("myTable");
		Table.innerHTML = "";

		for (var l = 0; l < data.newMembers.length; l++) {
			var row = table.insertRow(1);
			var cell1 = row.insertCell(0);
			var cell2 = row.insertCell(1);
			var cell3 = row.insertCell(2);
			var cell4 = row.insertCell(3);
			var cell5 = row.insertCell(4);
			var cell6 = row.insertCell(5);

			cell1.innerHTML = data.newMembers[l].firstname;
			cell2.innerHTML = data.newMembers[l].lastname;
			cell3.innerHTML = data.newMembers[l].address;
			cell4.innerHTML = data.newMembers[l].phone;
			cell5.innerHTML = '<button type="submit" id="deleteMember'+data.newMembers[l].memberId+'" class="deleteMemberBtn" value="'+data.newMembers[l].memberId+'">Delete</button>';
			cell6.innerHTML = '<button type="submit" id="editMember'+data.newMembers[l].memberId+'" class="editMemberBtn" value="'+data.newMembers[l].memberId+'">Edit</button>';
			console.log(data.newMembers[i].memberId)
		}

		var btns = document.getElementsByClassName("deleteMemberBtn");

		for(let p = 0; p < btns.length; p++){
			let k = btns.length - (p+1);
		    var button = btns[k]; 
			button.addEventListener("click", () => {deleteButtonWasClicked(data.newMembers[p].memberId)},true);
		}
		
		var ebtns = document.getElementsByClassName("editMemberBtn");

		for(let p = 0; p < ebtns.length; p++){
			let k = ebtns.length - (p+1);
		    var button = ebtns[k]; 
			button.addEventListener("click", () => {editbuttonWasClicked(data.newMembers[p].memberId)},true);
		}
		

		
		
	}
	
	document.addEventListener("DOMContentLoaded", init(), true);
	
	const addbuttonElement = document.getElementById("addMember");
	addbuttonElement.addEventListener("click", addbuttonWasClicked, true);
	
	const editbuttonElement = document.getElementById("editMember");
	editbuttonElement.addEventListener("click", skiftebuttonWasClicked, true);



	

}
/*
 * class UIHandler{
 * 
 * const ui = new UIHandler()
 * 
 * 
 * ui.deleteMemberCallback = (id) => { console.log(`Delete button of member with
 * id ${id} was clicked.`) const member=ui.getMember(id) console.log(`Member is
 * ${member.firstname} ${member.lastname} with telephone ${member.phone} and
 * address ${member.address}.`) }
 * 
 * ui.editMemberCallback = (id) => { console.log(`Edit button of member with id
 * ${id} was clicked.`) const member=ui.getMember(id) console.log(`Member is
 * ${member.firstname} ${member.lastname} with telephone ${member.phone} and
 * address ${member.address}.`) } }
 */
