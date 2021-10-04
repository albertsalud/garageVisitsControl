package com.albertsalud.garage.model.services;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.albertsalud.garage.model.dao.TagDAO;
import com.albertsalud.garage.model.entities.Tag;
import com.albertsalud.garage.model.entities.User;

@Service
public class TagServices {
	
	@Autowired
	private TagDAO tagDao;
	
	public List<Tag> findByUser(User user){
		return tagDao.findByUser(user);
	}
	
	public void manageTags(User user, String newTags) {
		List<Tag> userTags = tagDao.findByUser(user);
		if(Strings.isNotEmpty(newTags)) {
			for(String currentTag : newTags.split(",")) {
				checkCurrentTag(userTags, currentTag, user);
			}
		}
	}

	private void checkCurrentTag(List<Tag> userTags, String currentTag, User user) {
		List<Tag> filteredTags = userTags
									.stream()
									.filter(tag -> {
										return tag.getValue().equalsIgnoreCase(currentTag);
										})
									.collect(Collectors.toList());
		
		if(filteredTags.isEmpty()) {
			tagDao.save(new Tag(user, currentTag));
		}
	}

}
